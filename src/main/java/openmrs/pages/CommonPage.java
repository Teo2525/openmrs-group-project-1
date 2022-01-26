package openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;


//use this class in case you need to store common element across all pages
public class CommonPage {

    protected  WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;

    }

    @FindBy(partialLinkText = "admin")
    WebElement admin;

    @FindBy(id = "selected_location")
    WebElement selectedImpatientWard;

    @FindBy(partialLinkText = "Logout")
    WebElement logoutLink;





}
