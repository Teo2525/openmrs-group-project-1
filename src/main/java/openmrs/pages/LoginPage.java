package openmrs.pages;

import openmrs.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for='username']")
    private WebElement usernameLable;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordLable;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Impatient Ward")
    private WebElement impatientWard;

    @FindBy(xpath = "//label[@for='sessionLocation']")
    private WebElement locationLable;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "cantLogin")
    private WebElement cantLoginLable;

    @FindBy(xpath = "//legend[@class='w-auto']")
    private WebElement loginLable;


    public void visitHomePage() {
        driver.get(ConfigReader.getProperty("url"));
    }


    public void login() {
        username.sendKeys(ConfigReader.getProperty("username"));
        password.sendKeys(ConfigReader.getProperty("password"));
        //click sing in
        //verify error
        //select location
        //click sign again
    }




    private void selectLocation() {

        verifyLocations();
        //seelct location inp ward
    }

    private void verifyLocations() {
        final List<WebElement> locations = driver.findElements(By.xpath("//ul[@id='sessionLocation']/li"));

    }
}
