package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasicData {
   // WebDriver
    private final WebDriver driver;
    public ChromeDriver browser;




    // Page Constructor
    public BasicData(WebDriver driver) {
        this.driver = driver;
    }
    // Selenide Locator Test
    String inhabited_type = "//nx-word[3]//div[@class='nx-dropdown__rendered']";

    // Enter Data Page Locators
    By hausratSchsdenUpBtn  =By.cssSelector(".nx-grid__column-6:nth-child(2) .nx-stepper__up .nx-icon--s");
    By hausratSchsdenDownBtn = By.cssSelector(".nx-grid__column-6:nth-child(2) .nx-stepper__down .nx-icon--s");
    By hauratStepper = By.cssSelector("#nx-number-stepper-0");
    By Fahrrad_Diebstahl_Up_btn = By.cssSelector(".u-margin-top-md .nx-stepper__up .nx-icon--s");
    By Fahrrad_Diebstahl_Down_btn = By.cssSelector(".u-margin-top-md .nx-stepper__down .nx-icon--s");
    By Fahrrad_Stepper = By.cssSelector("#nx-number-stepper-1");

    By all_cookie_btn = By.id("onetrust-accept-btn-handler");
    By zip_txtbox = By.xpath("//input[@type='tel' and @placeholder='PLZ']");
    By marital_status_selector = By.cssSelector("#nx-input-1");
    By inhabited_type_selector = By.xpath("//nx-word[3]//div[@class='nx-dropdown__rendered']");
    By postcode_error_box = By.cssSelector(".nx-margin-top-2m.context-error.ng-star-inserted");
    By livingSpace = By.cssSelector("[formcontrolname='livingSpace']");
    By birthdate = By.cssSelector("[placeholder='TT.MM.JJJJ']");
    By Einfamilienhaus_radio = By.xpath("//nx-radio[@class='has-margin-right nx-radio-button--big-label ng-star-inserted']//div[@class='nx-radio__circle']");
    By Mehrfamilienhaus_radio = By.xpath("//nx-radio[@class='nx-radio-button--big-label ng-star-inserted']//div[@class='nx-radio__circle']");
   public By Ja_radio = By.xpath("//nx-radio[@class='nx-radio-button--big-label']//div[@class='nx-radio__circle']");
    By Nein_radio = By.xpath("//nx-radio[@class='u-margin-left-20 nx-radio-button--big-label']//div[@class='nx-radio__circle']");
    By Jetzt_Tarif_berechnenf_btn = By.xpath("//button[@class='u-margin-none nx-button--emphasis nx-button--medium']");
    By strasse_dropdown = By.cssSelector(".ng-invalid > .nx-dropdown__container");
    By Alllee_strasse = By.cssSelector("#nx-dropdown-item-7 .nx-dropdown-results__option-label > span");
    By strasse_numer = By.cssSelector("#nx-input-3");
    By home_page_heading = By.cssSelector(".nx-margin-bottom-0");
    By Error_box = By.cssSelector(".nx-margin-top-2m:nth-child(4) span");
    By livingSpaceError = By.cssSelector(".nx-message__content > .ng-star-inserted");
    By pop_message = By.cssSelector(".nx-button__content-wrapper");
    By cloes_btn = By.xpath(".nx-icon--close");
    By error_msg_301 = By.xpath(".nx-message__content > .ng-star-inserted");
    By Anmelden = By.cssSelector(".js-login-section > .u-hidden-medium");
    By AnsprechpartnerLink = By.cssSelector(".c-azde-header__tied-agent__text__name");
    By login_btn = By.cssSelector(".js-login:nth-child(2)");
    By logo_link = By.cssSelector(".c-header__logo-image");
    By postCode = By.cssSelector(".nx-margin-top-2m");
    By dobError = By.xpath("//span[.='Bitte geben Sie ein gültiges Geburtsdatum an.']");
    By age18Error = By.xpath("//span[contains(.,'Um diese Versicherung abschließen zu können, müssen Sie mindestens 18 Jahre alt')]");

    // Marital Status Dropdown Elements
    By mit_Partner_und_Kinder = By.xpath("//span[.='mit Partner und Kind(ern)']");
    By alleine = By.xpath("//span[.='alleine']");
    By mit_Partner = By.xpath("//div[@class='nx-dropdown-results__option nx-dropdown-results__option--selected']//span[.='mit Partner']");
    By mit_Kind = By.xpath("//span[.='mit Kind(ern)']");
    By angebot_page_heading = By.cssSelector(".nx-heading--section:nth-child(2)"); //$(".nx-heading--section:nth-child(2)").shouldHave(text("Unser Angebot für Sie"))

    //Inhabitant Status Dropdown List
    By standig_bewohnt = By.xpath("//span[.='ständig bewohnt']");
    By nitch_standig_bewohnt = By.xpath("//span[.='nicht ständig bewohnt']");

                                     /*Error Locators*/
    By empty_form_err = By.xpath("//nx-message[contains(.,'Bitte geben Sie eine Postleitzahl ein.Bitte geben Sie eine Straße ein.Bitte gebe')]");
    By Haushalt_err = By.xpath("//span[.='Bitte geben Sie an, wo sich der Haushalt befindet.']");
    By Option_aus_err = By.xpath("//span[.='Bitte wählen Sie eine Option aus']");


                                /*Enter Data Page Methods*/

    // Press Hausrat_Schsden_Up_btn to Increse
    public void Hausrat_Schsden_Up_btn(){
        $(hausratSchsdenUpBtn).click();
    }

    // Press Hausrat_Schsden_Down_btn to Decrese
    public void Hausrat_Schsden_Down_btn(){
        $(hausratSchsdenDownBtn).click();
    }

    // Haurat_Stepper Ccount
    public void Haurat_Stepper(){
        $(hauratStepper);
    }



    // Get Heading
    public BasicData getPageHeading(){
        $(home_page_heading).shouldHave(text("Hausrat Tarif berechnen"));
        return this;
    }

    // Get Heading
    public BasicData getHeadingsText(By by, String str){
        $(by).shouldHave(text(str));
        return this;
    }

    // Assert Angebot Page Heading
    public void AssertAngebot_page_heading(){
        String angebot_str = "Unser Angebot für Sie";
        getHeadingsText(angebot_page_heading ,angebot_str);
    }

    // Set Mehrfamilienhaus_radio Button
    public BasicData set_Mehrfamilienhaus_radio(){
        if (!$(Mehrfamilienhaus_radio).isSelected()){
            $(Mehrfamilienhaus_radio).click();
        }
        return this;
    }

    // Set Ja_radio Button
    public BasicData set_Ja_radio(){
        if (!$(Ja_radio).isSelected()){
            $(Ja_radio).click();
        }
        return this;
    }

    // Set Nein_radio Button
    public BasicData set_Nein_radio(){
        if (!$(Nein_radio).isSelected()){
            $(Nein_radio).click();
        }
        return this;
    }

    // Set Einfamilienhaus_radio Button
    public BasicData set_Einfamilienhaus_radio(){
        if (!$(Einfamilienhaus_radio).isSelected()){
            $(Einfamilienhaus_radio).click();
        }
        return this;
    }


    // Click Jetzt_Tarif_berechnenf_btn
    public BasicData click_Jetzt_Tarif_berechnenf_btn(){
        $(Jetzt_Tarif_berechnenf_btn).click();
        return this;
    }

    // Set Apartment Type
    public BasicData setApartment_type(By locator_radio){
        $(locator_radio).click();
        return this;
    }

    // Click inhabited_type_selector
    public BasicData click_inhabited_type_selector(){
        $(inhabited_type_selector).click();
        $(standig_bewohnt).click();
        return this;
    }




    // Get Page Title
    public BasicData getPageTitle(){
        String page_title_text = "Hausratversicherung berechnen: ab 2,88€/mtl. | Allianz";
        String page_title = Selenide.title();
        Assert.assertEquals(page_title,page_title_text);
        return this;
    }

    // Set Date of Birth
    public BasicData setDateOfBirth(String dob){
        $(birthdate).val(dob);
        return this;
    }



    // Set Living Space
    public BasicData setLivingSpace(String dimension){
        $(livingSpace).val(dimension);
        return this;
    }


   // Set Inhabitant Type
    public BasicData setInhabitantType(){
        $(standig_bewohnt).click();
        return this;
    }

    // Set Zip Code
    public BasicData setZipcode(String zipcode) throws InterruptedException {
      // Alt Method
        Thread.sleep(10000);
        $(zip_txtbox).shouldBe(Condition.visible).val(zipcode);

        //$(zip_txtbox).val(zipcode);
        return  this;
    }




    // Set Marital Status
    public BasicData setMaritalStatus(){
        // Click Marital status Dropdown Menu
        $(marital_status_selector).click();

        // Select Alleine from the Menu
        WebElement alleine_btn =$(alleine);
        // Check if element is Present
        Assert.assertEquals(true, alleine_btn.isDisplayed());
        // Click on alleine in the dropdown menu
        alleine_btn.click();
        return this;
    }

    // Open website
    public BasicData open_web(String url){
        open(url);
        if ($(all_cookie_btn).isDisplayed()){
            $(all_cookie_btn).click();
        }

        return this;
    }



    public void verify_all_errors() {
        isPresent(empty_form_err);
        isPresent(Haushalt_err);
        isPresent(Option_aus_err);

    }
// Finds element on a page
    public boolean isPresent(By locator){
        try {
            $(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

// Scrolls to an element on a page
    public BasicData scrollDown() throws InterruptedException {

        $(Jetzt_Tarif_berechnenf_btn).scrollTo();
//        WebElement elem = $(Jetzt_Tarif_berechnenf_btn);
//        elem.sendKeys(Keys.DOWN);
//        Thread.sleep(5000);
        return this;
    }


    // set strasse_dropdown
    public BasicData clickStrasseDropdown() throws InterruptedException {
        // Waits for element tobe present on the page before clicking
        $(strasse_dropdown).shouldBe(Condition.visible).click();
        return this;
    }

    // set Allee_strasse
    public BasicData clickAllee_strasse(){
        $(Alllee_strasse).shouldBe(Condition.visible).click();
        return this;
    }

    // set strasse_numer
    public BasicData setstrasse_numer(String strass_num){
        $(strasse_numer).val(strass_num);
        return this;
    }

    public BasicData fill_data(String zip, String num, String dimension, String dob) throws InterruptedException {
        setZipcode(zip);
        Thread.sleep(5000);
        clickStrasseDropdown();
        clickAllee_strasse();
        setstrasse_numer(num);
        setLivingSpace(dimension);
        setDateOfBirth(dob);
        scrollDown();
        set_Einfamilienhaus_radio();
        set_Nein_radio();
        isPresent(Jetzt_Tarif_berechnenf_btn);
        click_Jetzt_Tarif_berechnenf_btn();


        return this;
    }

    // Set Alleine
    public BasicData setAlleine(){
        $(alleine).click();
        return  this;
    }




    public void AssertPostalCodeError() throws InterruptedException {
        scrollDown();
        $(postcode_error_box).should(exist);
        $(strasse_dropdown).shouldNotBe(Condition.visible);
        $(strasse_numer).shouldNotBe(Condition.visible);
    }

    public void AssertCorrectAllWrongInput() {
        $(Error_box).shouldHave(text("Achtung: Bitte korrigieren Sie alle Fehler auf dieser Seite, um fortfahren zu können."));

    }

    public void AssertLivingSpaceLimit() {
        if(Integer.parseInt($(livingSpace).getValue()) ==0 ){
            //Get Error when Living space value is 0 and below
            $(livingSpaceError).shouldHave(text("Die Wohnfläche muss zwischen 1 und 300 m² betragen."));

        }else if(Integer.parseInt($(livingSpace).getValue()) > 300) {
            //Get Error when Living space value is 301 and above
            $(pop_message).shouldHave(text("SCHLIESSEN"));
            $(pop_message).click();


        }
    }


    // This makes sure that Anmenden Link is Enabled and Present for Clicking
    public void AssertAnmeldenLinkIsClicable() {
        $(Anmelden).should(exist).isEnabled();
        $(Anmelden).should(exist).click();
        $(login_btn).should(exist);
    }


    public void AssertAnsprechpartnerLinkIsClickable() {
        $(AnsprechpartnerLink).should(exist).isEnabled();
    }

    public void AssertLogoImagePresent() {
        $(logo_link).should(exist).isImage();
    }

    public void AssertHausratIncrease() {
        $(Ja_radio).scrollTo();
       int init_counter = Integer.parseInt($(hauratStepper).getValue());
       Hausrat_Schsden_Up_btn();
       int next_counter = Integer.parseInt($(hauratStepper).getValue());
       if(next_counter>init_counter){
           $(hausratSchsdenUpBtn).isEnabled();
       }else {
           $(hausratSchsdenUpBtn).isDisplayed();
       }

    }

    public void AssertAngebotDOBerror() {
        $(dobError).scrollTo();
        $(dobError).shouldHave(text("Bitte geben Sie ein gültiges Geburtsdatum an."));
    }

    public void InvalidAge() {
        $(age18Error).scrollTo();
        $(age18Error).shouldHave(text("Um diese Versicherung abschließen zu können, müssen Sie mindestens 18 Jahre alt sein."));


    }
}
