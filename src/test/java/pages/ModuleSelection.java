package pages;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.*;
import org.testng.Assert;

public class ModuleSelection {
    WebDriver driver;

    /*Page Constructor*/
    public ModuleSelection(WebDriver driver){
        this.driver = driver;
    }

    /*Offer Received Page Locators*/
By insurance_deduction_period_dropdown = By.cssSelector("#nx-dropdown-rendered-4");
By monthly_insurance_item = By.cssSelector("[nxvalue='M'] font > font");
By quarterly_insurance_item = By.cssSelector("[nxvalue='V'] font > font");
By half_a_year_insurance_item = By.cssSelector("[nxvalue='H'] font > font");
By yearly_insurance_item = By.cssSelector("[nxvalue='J'] font > font");
By recommended_dropdown = By.cssSelector("#nx-dropdown-rendered-5 > .ng-star-inserted");
By Insured_amount_field = By.cssSelector("#nx-input-4");
By deductible_dropdown = By.cssSelector(".nlfRetention .nx-dropdown__chevron");
By error_msg_box = By.cssSelector(".nx-message__content > span");
By Basic_btn = By.cssSelector("#product_HH001");
By Smart_btn = By.cssSelector("#product_HH002");
By Komfort_btn = By.cssSelector("#product_HH003");
By Premium_btn = By.cssSelector("#product_HH004");
By Fahrradschutz_btn = By.cssSelector("#nxt-option-card-button-0");
By Fahrradschutz_btnSmart = By.xpath("//button[@class='nx-button--primary nx-button--small ng-star-inserted']/span[@class='nx-button__content-wrapper']/span[contains(.,'Ausgewählt')]");
By BasicAmount = By.xpath("//nx-comparison-table-flex-row[@class='ng-tns-c176-6 is-header-row is-sticky ng-star-inserted']//div[@class='nx-comparison-table__cell ng-star-inserted is-selected']//p[@class='product-price nx-margin-bottom-0 ng-star-inserted']");
By TotalAmount = By.xpath("//h3[@class='nxt-shopping-cart__text nxt-shopping-cart__price nx-heading--subsection-xsmall ng-star-inserted']");
By SmartAmount = By.xpath("//nx-comparison-table-flex-row[@class='ng-tns-c176-6 is-header-row is-sticky ng-star-inserted']//div[3]//p[@class='product-price nx-margin-bottom-0 ng-star-inserted']");
By KomforAmount = By.xpath("//nx-comparison-table-flex-row[@class='ng-tns-c176-6 is-header-row is-sticky ng-star-inserted']//div[4]//p[@class='product-price nx-margin-bottom-0 ng-star-inserted']");
By PremiumAmount = By.cssSelector("[headers='nx-comparison-table-cell-3'][role='columnheader'] .nx-margin-bottom-0");
By Glasschutz_btn = By.xpath("//*[@id='nxt-option-card-button-2']");
By fahrradschutzAmount = By.xpath("//div[contains(text(),'0,85 €')]");
By h1msg = By.cssSelector(".u-text-align-center");


    BasicData page = new BasicData(driver);


    public ModuleSelection setInsuredAmount(String amount) {
        $(Insured_amount_field).clear();
        $(Insured_amount_field).shouldBe(visible).val(amount);
        int getInsuredAmount = Integer.parseInt($(Insured_amount_field).getValue());
        Assert.assertNotEquals(getInsuredAmount,5000);

        return this;
    }

    public ModuleSelection AssertOfferPageIsLoadedSuccessfully() {
        page.AssertAngebot_page_heading();
        return this;
    }


    public ModuleSelection AssertInsuredMinimumAmountError() {
        $(error_msg_box).shouldHave(selectedText("Bitte beachten Sie: Bei Absenkung der Versicherungssumme unter 650 € pro Quadratmeter Wohnfläche kann im Schadenfall eine eventuelle Unterversicherung geprüft werden."));
        return this;
    }

    public String basicAmount;
    public ModuleSelection BASIC_InsuranceCover() throws InterruptedException {
        if(!$(Basic_btn).isSelected()){
            // Verify Fahrradschutz Button is Disabled on the Page
            $(Basic_btn).scrollTo();
            Assert.assertFalse($(Fahrradschutz_btn).isSelected());
            $(Basic_btn).click();
            basicAmount = $(BasicAmount).getValue();
            Thread.sleep(5000);
            $(Fahrradschutz_btn).scrollTo();
            Assert.assertTrue($(Fahrradschutz_btn).isEnabled());// code works to this point
            $(TotalAmount).scrollTo();
            String totalamt = $(TotalAmount).getValue();
            Assert.assertEquals(basicAmount,$(TotalAmount).getValue());


        }


        return this;
    }

    public ModuleSelection SMART_InsuranceCover() throws InterruptedException {

        if(!$(Smart_btn).isSelected()){
            // Verify Fahrradschutz Button is Disabled on the Page
            $(Smart_btn).scrollTo();
            Assert.assertFalse($(Fahrradschutz_btn).isSelected());
            $(Smart_btn).click();
            String smartAmount = $(SmartAmount).getValue();
            Thread.sleep(5000);
            $(TotalAmount).scrollTo();
            $(TotalAmount).getValue();
            Assert.assertEquals(smartAmount,$(TotalAmount).getValue());

        }

        return this;
    }


    public ModuleSelection KOMFORT_InsuranceCover() throws InterruptedException {
        if(!$(Komfort_btn).isSelected()){
            // Verify Fahrradschutz Button is Disabled on the Page
            $(Komfort_btn).scrollTo();
            Assert.assertFalse($(Fahrradschutz_btn).isSelected());
            $(Komfort_btn).click();
            String komfortAmount = $(KomforAmount).getValue();
            Thread.sleep(5000);
            $(TotalAmount).scrollTo();
            $(TotalAmount).getValue();
            Assert.assertEquals(komfortAmount,$(TotalAmount).getValue());

        }

        return this;
    }

    public ModuleSelection PREMIUN_InsuranceCover() throws InterruptedException {
        if(!$(Premium_btn).isSelected()){
            // Verify Fahrradschutz Button is Disabled on the Page
            $(Premium_btn).scrollTo();
            Assert.assertFalse($(Fahrradschutz_btn).isSelected());
            $(Premium_btn).click();
            String premiumAmount = $(PremiumAmount).getValue();
            Thread.sleep(5000);
            $(TotalAmount).scrollTo();
            $(TotalAmount).getValue();
            Assert.assertEquals(premiumAmount,$(TotalAmount).getValue());

        }

        return this;
    }
By totalAmout = By.xpath("//h3[@class='nxt-shopping-cart__text nxt-shopping-cart__price nx-heading--subsection-medium nx-heading--negative ng-star-inserted']");
    public void addFahrradschutzToPackage() throws InterruptedException {
        $(h1msg).scrollTo();
        $(Fahrradschutz_btn).click();
        $(Fahrradschutz_btn).isSelected();
        $(totalAmout).scrollTo();
        $(totalAmout).shouldHave(text(" 12,03 € "));


    }
}
