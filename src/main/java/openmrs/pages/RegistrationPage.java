package openmrs.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class RegistrationPage extends CommonPage {

    private SoftAssert softAssert;
    private Faker faker;

    public RegistrationPage(WebDriver driver, SoftAssert softAssert) {
        super(driver);
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


    public void register() {
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

    }


    private void enterNames() {

        String firstName = faker.name().firstName();
        givenNameInput.sendKeys(firstName);
        Assert.assertTrue(givenNameInput.isDisplayed());

        String middleName = faker.name().nameWithMiddle();
        familyNameInput.sendKeys(middleName);
        Assert.assertTrue(familyNameInput.isDisplayed());

        String lastName = faker.name().lastName();
        familyNameInput.sendKeys(lastName);
        Assert.assertTrue(familyNameInput.isDisplayed());

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
        String adress = faker.address().streetAddress();
        adress1.sendKeys(adress);
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

        String phoneNumber1 = faker.phoneNumber().phoneNumber();
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

}



