package openmrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import openmrs.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class PatientRegistrationTests {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @Test
    public void patientRegisterTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, softAssert);
        HomePage homePage = new HomePage(driver, softAssert);
        RegistrationPage registrationPage = new RegistrationPage(driver, softAssert);
        PatientDetails patientDetails = new PatientDetails(driver, softAssert);

        loginPage.visitLoginPage();
        loginPage.login();

    //    homePage.verifyHomePageTitle();
        homePage.selectTab();
        registrationPage.register();


        // patientDetails.successMesg();
        // patientDetails.validatePersonDetails();
        Thread.sleep(2000);

        patientDetails.sendMessage();




    }


}
