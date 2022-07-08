package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasicData;
import pages.ModuleSelection;
import utils.CommonData;

public class ModuleSelectionTest {
    WebDriver driver;
    ModuleSelection offer = new ModuleSelection(driver);
    BasicData page = new BasicData(driver);
    CommonData utils = new CommonData();
    @BeforeTest
    public void setUp(){
        page.open_web(utils.url);
    }

    @Test
    public void TC_012_userCannotEnterInsuranceAmountLessThan_€650() throws InterruptedException {
        //Given is On Offer Page and User selects Any Package
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);
        offer.AssertOfferPageIsLoadedSuccessfully();

        //When Insured Amount is Less than € 650
        offer.setInsuredAmount(utils.less_amount);

        //Then User should see and Error Message
        offer.AssertInsuredMinimumAmountError();
    }

    /*BASIC  offer VERIFICATION*/
    @Test
    public void TC_013_ValidateBASICOfferAmount() throws InterruptedException {


        //Given User is On offer page
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);
        offer.AssertOfferPageIsLoadedSuccessfully();
        //When User Clicks On Auswählen Button on any of the card
        //Then Offer Amount Should be added to Cart
        //Then Total Cart Amount Should Be Updated
        offer.BASIC_InsuranceCover();


    }

    /*SMART  offer VERIFICATION*/
    @Test
    public void TC_014_ValidateSMARTOfferAmount() throws InterruptedException {
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);
        offer.AssertOfferPageIsLoadedSuccessfully();
        offer.SMART_InsuranceCover();
    }

    /*KOMFORT  offer VERIFICATION*/
    @Test
    public void TC_015_ValidateKOMFORTOfferAmount() throws InterruptedException {
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);
        offer.AssertOfferPageIsLoadedSuccessfully();
        offer.KOMFORT_InsuranceCover();
    }

    /*PREMIUM  offer VERIFICATION*/
    @Test
    public void TC_016_ValidatePREMIUMOfferAmount() throws InterruptedException {
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);
        offer.AssertOfferPageIsLoadedSuccessfully();
        offer.PREMIUN_InsuranceCover();
    }

    /*VALIDATE USER IS ON MODULE SELECTION PAGE*/
    @Test
    public void TC_017_ValidateUserIsOnOfferPage() throws InterruptedException {


        //Given User is On offer page
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);

        //Then User Can See BASIC, Smart, Komfort, Premium offer Cards
        offer.AssertOfferPageIsLoadedSuccessfully();

    }
    /*ADD FAHRRADSCHUTZ TO BASIC  offer VERIFICATION*/
    @Test
    public void TC_018_VerifyUserCanAddFahrradschutzTp_BASIC_PackageFromOfferpage() throws InterruptedException {
        //Given User is on Offer Page
        page.fill_data(utils.PostalCode,utils.streetNum,utils.measurement,utils.Valid_DOB);
        offer.AssertOfferPageIsLoadedSuccessfully();

        //When an Offer Button is Clicked
        offer.BASIC_InsuranceCover();

        //And Offer Amount is Added To Cart
        offer.addFahrradschutzToPackage();

        //Then User Should be able to see Offer Amount on the Page
    }




}
