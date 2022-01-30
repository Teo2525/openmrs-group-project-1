package openmrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import openmrs.pages.*;
import openmrs.utils.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class PatientRegistrationTests {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup( ) throws Exception {
        driver = BrowserDriver.getDriver();
        softAssert = new SoftAssert();

//        driver = new ChromeDriver();

    }

    @Test
    public void patientRegisterTest() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver, softAssert);
        HomePage homePage = new HomePage(driver, softAssert);
        RegistrationPage registrationPage = new RegistrationPage(driver, softAssert);
        GeneralAction generalAction = new GeneralAction(driver,softAssert);


        loginPage.visitLoginPage();
        loginPage.login();

//       homePage.verifyHomePageTitle();
        homePage.selectTab();
        registrationPage.register();
        generalAction.verifyGeneralAction();





//        softAssert.assertAll();






    }


}
