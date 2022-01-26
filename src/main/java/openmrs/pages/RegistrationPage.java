package openmrs.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class RegistrationPage extends CommonPage {

    private WebDriver driver;
    private SoftAssert softAssert;
    private Faker faker;

    public RegistrationPage(WebDriver driver, SoftAssert softAssert) {
        super(driver);
        this.faker = new Faker();
        this.softAssert =softAssert;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='fr9307-field']")
    private WebElement givenNameInput;

    @FindBy(xpath = "//input[@id='fr9935-field']")
    private WebElement familyNameInput;

    @FindBy(xpath = "//button[@id='next-button']")
    private WebElement nextBtn;



    private void enterNames(){

    }
    private void enterGender(){

    }





}



