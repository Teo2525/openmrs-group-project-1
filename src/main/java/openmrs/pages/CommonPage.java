package openmrs.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


//use this class in case you need to store common element across all pages
public class CommonPage {

     WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;

    }

    @FindBy(partialLinkText = "admin")
    WebElement admin;

    @FindBy(id = "selected_location")
    WebElement selectedImpatientWard;

    @FindBy(partialLinkText = "Logout")
    WebElement logoutLink;

















}
