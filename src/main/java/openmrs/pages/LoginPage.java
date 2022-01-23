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

import java.util.List;


public class LoginPage {

    // declare the WebDriver Object
    private WebDriver driver;


    // create Constructor for WedDriver Object
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    // find element for IMPATIENT WARD
    @FindBy(id = "Inpatient Ward")
    private WebElement impatientWard;

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

    @FindBy(id = "sessionLocationError")
    private WebElement errorWarning;


    // 1. get to the HomePage
    public void visitHomePage() {
        driver.get(ConfigReader.getProperty("url"));      // use the url from the config.properties file
        String title = driver.getTitle();
        Assert.assertEquals(title, "Login");
    }


    public void login() {
        username.sendKeys(ConfigReader.getProperty("username"));  // enter username from config.properties
        password.sendKeys(ConfigReader.getProperty("password"));  // enter password from config.properties

        //click sing in
        loginButton.click();
        //verify error
        Assert.assertTrue(errorWarning.isDisplayed(), "You must choose a location!");

        //select location
        impatientWard.click();

        //click sign again
        loginButton.click();


    }

    private void selectLocation() {

        verifyLocations();
        //select location Inpatient Ward
        Assert.assertEquals("impatientWard", "Impatient Ward");
    }



    private void verifyLocations() {
        final List<WebElement> locations = driver.findElements(By.xpath("//ul[@id='sessionLocation']/li"));
        for (int i = 0; i < locations.size(); i++) {
        

        }

        }


    }






