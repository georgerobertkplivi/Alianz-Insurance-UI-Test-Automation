package tests;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.BasicData;
import utils.CommonData;


public class BasicDataTest {
    /*Initialize Driver*/
    WebDriver driver;

    /*Initialize Page Classes*/
    BasicData page = new BasicData(driver);
    CommonData utils = new CommonData();
    public  String web_url = utils.url;

    /*Test Data*/
    String PostalCode = utils.PostalCode;
    String streetNum = utils.streetNum;
    String Valid_DOB = utils.Valid_DOB;
    String measurement = utils.measurement;

    /*SetUp Class To Run Common Methods and Action Similar to all Pages*/
    @BeforeTest
    public void setUp(){
        page.open_web(web_url);
    }


    /*Test Data*/
    @Test
    public void TC_001_Verify_Allianz_webpage_loads_successfully(){
        //page.open_web(web_url);
        page.getPageTitle();
    }

    @Test
    public void TC_002_Verify_Empty_form_submission_failed() throws InterruptedException {
        //page.open_web(web_url);
        Thread.sleep(10000);
        page.scrollDown();
        page.click_Jetzt_Tarif_berechnenf_btn();
        page.verify_all_errors();
    }



    @Test
    public void TC_003_Verify_UserCanGoToAngebotPageFillingFormWithValidData() throws InterruptedException {
//        page.open_web(web_url);
        page.fill_data(PostalCode,streetNum,measurement,Valid_DOB);
        page.AssertAngebot_page_heading();
    }



    @Test
    public void TC_004_Verify_UserShouldSeeErrorFillingFormWith_Invalid_ZipCode() throws InterruptedException {
        page.open_web(web_url);
        page.setZipcode(utils.invalidPostalCode);
        page.AssertPostalCodeError();
    }

    @Test
    public void TC_005_Verify_UserCannotGoToAngebotPageFillingFormWith_Invalid_ZipCode() throws InterruptedException {
//        page.open_web(web_url);
        page.setZipcode(utils.invalidPostalCode);
        page.setLivingSpace(measurement).setDateOfBirth(Valid_DOB).set_Einfamilienhaus_radio().set_Nein_radio();
        page.scrollDown().click_Jetzt_Tarif_berechnenf_btn();
        page.AssertCorrectAllWrongInput();

    }

    @Test
    public void TC_006_Verify_LivingSpaceCannotBeLessThan_1o_or_GreatThan_300() throws InterruptedException {
//        page.open_web(web_url);
        page.setZipcode(PostalCode);
        page.setLivingSpace(utils.invladDimensionGreater);
        page.setDateOfBirth(Valid_DOB);
        page.AssertLivingSpaceLimit();


    }

    @Test
    public void TC_007_UserCanClick_Anmelden_Link() throws InterruptedException {
        Thread.sleep(3000);
        page.AssertAnmeldenLinkIsClicable();
    }

    @Test
    public void TC_008_UserCanClick_Ansprechpartner_Link(){
        page.AssertAnsprechpartnerLinkIsClickable();
    }


    @Test
    public void TC_009_IsLogoPresent(){
        page.AssertLogoImagePresent();

    }



    @Test
    public void TC_010_UserCannotGoToReceivedOfferPageWhenDOBisLessThan_18Years() throws InterruptedException {
        page.fill_data(PostalCode,streetNum,measurement,utils.invalidAge_DOB);
        page.InvalidAge();
    }

    @Test
    public void TC_011_Verify_UserCanGoToAngebotPageFillingFormWithInvalidDOB() throws InterruptedException {
//        page.open_web(web_url);
        page.fill_data(PostalCode,streetNum,measurement,utils.invalid_DOB);
        page.AssertAngebotDOBerror();
    }



}
