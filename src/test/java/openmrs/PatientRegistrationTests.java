package openmrs;

import openmrs.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by tairovich_jr on 2022-01-22.
 */
public class PatientRegistrationTests {

WebDriver driver;
    @Test
    public void patientRgisterTest(){

        LoginPage loginPage = new LoginPage(driver);


    }

    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
    }
}
