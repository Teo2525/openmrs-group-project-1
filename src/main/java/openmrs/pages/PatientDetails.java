package openmrs.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PatientDetails extends CommonPage {

    private SoftAssert softAssert;
    private Faker faker;


    public PatientDetails(WebDriver driver, SoftAssert softAssert) {
        super(driver);
        this.faker = new Faker();
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//script[contains(text(),'successMessage')]/text()")
    private WebElement successRegistration;

    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    private WebElement givenNameBox;

    @FindBy(xpath = "//span[@class='PersonName-familyName']")
    private WebElement familyNameBox;

    @FindBy(xpath = "//div[@class='gender-age col-auto']")
    private WebElement genderAgeBirthDate;

    @FindBy(xpath = "//i[@class='icon-sticky-note']")
    private WebElement notesIcon;
    @FindBy(xpath = "//textarea[@placeholder='Enter a note']")
    private WebElement sendMessage;


    public void successMesg() {
        String actualText = successRegistration.getText().trim();
        Assert.assertTrue(actualText.contains("Created Patient Record"));
    }

    public void validatePersonDetails() {
        Assert.assertTrue(givenNameBox.isDisplayed());
        Assert.assertTrue(familyNameBox.isDisplayed());
        Assert.assertTrue(genderAgeBirthDate.isDisplayed());
    }

    public void sendMessage() {
        notesIcon.click();
        sendMessage.sendKeys("Hi everyone");
    }


}

