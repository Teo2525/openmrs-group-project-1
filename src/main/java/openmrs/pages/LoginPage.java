package openmrs.pages;

import openmrs.utils.ConfigReader;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class LoginPage {

    // declare the WebDriver Object
    private WebDriver driver;
    private SoftAssert softAssert;


    // create Constructor for WedDriver Object
    public LoginPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);

    }


    //========================= Find all elements on Login Page ============================
    //find element for USER LABEL
    @FindBy(xpath = "//label[@for='username']")
    private WebElement usernameLabel;


    //find element for USER INPUT
    @FindBy(id = "username")
    private WebElement username;

    //find element for PASSWORD LABEL
    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordLabel;

    //find element for PASSWORD INPUT
    @FindBy(id = "password")
    private WebElement password;

    //find element for LOCATION LABEL
    @FindBy(xpath = "//label[@for='sessionLocation']")
    private WebElement locationLabel;

    //find element for LOGIN BUTTON
    @FindBy(id = "loginButton")
    private WebElement loginButton;


    // find element for CAN'T LOGIN
    @FindBy(id = "cantLogin")
    private WebElement cantLoginLabel;

    //find element for LOGIN LABEL
    @FindBy(xpath = "//legend[@class='w-auto']")
    private WebElement loginLabel;

    // find element errorWarning
    @FindBy(id = "sessionLocationError")
    private WebElement errorWarning;

    // find element for IMPATIENT WARD
    @FindBy(id = "Inpatient Ward")
    private WebElement impatientWard;

    // find element for OUTPATIENT CLINIC
    @FindBy(id = "Outpatient Clinic")
    private WebElement outpatientClinic;

    // find element for ISOLATION WARD
    @FindBy(id = "Isolation Ward")
    private WebElement isolationWard;

    // find element for PHARMACY
    @FindBy(id = "Pharmacy")
    private WebElement pharmacy;

    // find element for LABORATORY
    @FindBy(id = "Laboratory")
    private WebElement laboratory;

    // find element for REGISTRATION DESK
    @FindBy(id = "Registration Desk")
    private WebElement registrationDesk;


    //========================= Methods ============================

    // 1. get to the HomePage
    public void visitLoginPage() {
        driver.get(ConfigReader.getProperty("url"));      // use the url from the config.properties file
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";
        softAssert.assertEquals(actualTitle, expectedTitle);      // verify the title of the page

    }

    public void login() {
        username.sendKeys(ConfigReader.getProperty("username"));  // enter username from config.properties
        password.sendKeys(ConfigReader.getProperty("password"));  // enter password from config.properties

        //click sing in
        loginButton.click();

        //verify error
        Assert.assertTrue(errorWarning.isDisplayed());

        //select location
        selectLocation();


        //click sign again
        loginButton.click();


    }

    private void selectLocation() {
        //      verifyLocations();
        verifyAllLabels();
//

        impatientWard.click();
        softAssert.assertTrue(impatientWard.isEnabled());

    }


    private void verifyLocations() {
        final List<WebElement> locations = driver.findElements(By.xpath("//ul[@id='sessionLocation']/li"));
        String[] locationNames = {"Inpatient Ward", "Outpatient Clinic", "Isolation Ward", "Pharmacy", "Laboratory", "Registration Desk"};
        int i = 0;
        for (WebElement location : locations) {
            softAssert.assertEquals(location.getText().trim(), locationNames[i]);
            i++;
        }

    }

    private void verifyAllLabels() {

        final String[] labels = {"Username:", "Password:", "Location for this session:", "LOGIN", "Can't log in?"};
        int i = 0;
        for (String label : labels) {
            softAssert.assertEquals(label.trim(), labels[i]);
            i++;
        }

    }
}














