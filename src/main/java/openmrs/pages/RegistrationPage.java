package openmrs.pages;

import com.github.javafaker.Faker;
import openmrs.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import static org.testng.Assert.*;


public class RegistrationPage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private Faker faker;
    //public static String PatientId;

    public RegistrationPage(WebDriver driver, SoftAssert softAssert) {
    this.driver=driver;
        this.faker = new Faker();
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='givenName']")
    private WebElement givenNameInput;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@name='familyName']")
    private WebElement familyNameInput;

    @FindBy(xpath = "//button[@id='next-button']")
    private WebElement nextBtn;

    @FindBy(xpath = "//option[@value='M']")
    private WebElement gender;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    private WebElement birthDate;

    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
    private WebElement birthMonth;

    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    private WebElement birthYear;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement adress1;

    @FindBy(xpath = "//input[@name='address2']")
    private WebElement adress2;

    @FindBy(xpath = "//input[@id='cityVillage']")
    private WebElement cityVillage;

    @FindBy(xpath = "//input[@id='stateProvince']")
    private WebElement stateProvince;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//input[@id='postalCode']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//select[@id='relationship_type']")
    private WebElement relationshipType;

    @FindBy(xpath = "//input[@placeholder='Person Name']")
    private WebElement personName;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement confirmBtn;

    @FindBy (xpath = "//*[@id='content']/div[6]/div[2]/div/span")
    private WebElement patientId;
    //*[@id="coreapps-diagnosesList"]/div[1]/h3





    public void register() throws IOException {
        enterNames();
        clickNext();

        enterGender();
        clickNext();

        enterBirthDate();
        clickNext();

        enterAddress();
        clickNext();

        enterPhoneNumber();
        clickNext();

        enterRelatives();
        clickNext();
//        verifyCheckButton();

       clickConfirm();

    }

    private void enterNames() {

        String firstName = faker.name().firstName();
        givenNameInput.sendKeys(firstName);
        assertTrue(givenNameInput.isDisplayed());

        String middleName = faker.name().nameWithMiddle();
        familyNameInput.sendKeys(middleName);
        assertTrue(familyNameInput.isDisplayed());

        String lastName = faker.name().lastName();
        familyNameInput.sendKeys(lastName);
        assertTrue(familyNameInput.isDisplayed());


    }


    private void enterGender() {
        gender.click();
    }

    private void enterBirthDate() {
        birthDate.sendKeys("2");

        Select month = new Select(birthMonth);
        month.selectByIndex(8);

        birthYear.sendKeys("1991");
    }


    private void clickNext() {
        nextBtn.click();
    }

    private void enterAddress() {
        String address = faker.address().streetAddress();
        adress1.sendKeys(address);
        softAssert.assertTrue(adress1.isDisplayed());

        String city = faker.address().city();
        cityVillage.sendKeys(city);
        softAssert.assertTrue(cityVillage.isDisplayed());

        String state = faker.address().state();
        stateProvince.sendKeys(state);
        softAssert.assertTrue(stateProvince.isDisplayed());

        String country1 = faker.address().country();
        country.sendKeys(country1);
        softAssert.assertTrue(country.isDisplayed());

        String postalCode1 = faker.address().zipCode();
        postalCode.sendKeys(postalCode1);
        softAssert.assertTrue(postalCode.isDisplayed());
    }

    private void enterPhoneNumber() {
        String phoneNumber1 = faker.phoneNumber().cellPhone().replace('.', '-');
        phoneNumber.sendKeys((phoneNumber1));
        softAssert.assertTrue(phoneNumber.isDisplayed());
    }


    private void enterRelatives() {
        Select relType = new Select(relationshipType);
        relType.selectByIndex(2);

        String persName = faker.name().fullName();
        personName.sendKeys(persName);
        softAssert.assertTrue(phoneNumber.isDisplayed());
    }

    private void verifyCheckButton() {

        final List<WebElement> okBtns = driver.findElements(By.xpath("//i[@class='icon-ok']/li"));
        for (int i = 0; i < okBtns.size(); i++) {
            assertTrue(okBtns.contains("icon-ok"));

        }
    }

    private void clickConfirm() throws IOException {
        confirmBtn.click();
        String patientText= patientId.getText();
        ConfigReader.setProperty("Id",patientText);


    }

}


