package openmrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import openmrs.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PatientRegistrationTests {

WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }

    @Test
    public void patientRegisterTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visitHomePage();
        loginPage.login();



    }


}
