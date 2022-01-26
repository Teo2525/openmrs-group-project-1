package openmrs.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import openmrs.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage extends CommonPage {


    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    private WebElement findPatientTab;

    @FindBy(id = "org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")
    private WebElement activeVisitsTab;

    @FindBy(xpath = "//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
    private WebElement registerPatientTab;

    @FindBy(id = "referenceapplication-vitals-referenceapplication-vitals-extension']")
    private WebElement captureVitalsTab;

    @FindBy(id = "appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")
    private WebElement appointmentsTab;

    @FindBy(id = "reportingui-reports-homepagelink-reportingui-reports-homepagelink-extension")
    private WebElement reportsTab;

    @FindBy(id = "coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")
    private WebElement dataManagementTab;

    @FindBy(id = "org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension")
    private WebElement configMetaDataTab;

    @FindBy(id = "coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension")
    private WebElement sysAdminTab;

    SoftAssert softAssert;

    public HomePage(WebDriver driver, SoftAssert softAssert) {
        super(driver);
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageTitle() {
        softAssert.assertEquals(driver.getTitle().trim(), "Home");
    }

    public void selectTab() {
        verifyTabs();
        verifyGeneralTabs();

        //select location Register A Patient
        softAssert.assertTrue(registerPatientTab.isDisplayed());
        registerPatientTab.click();


    }


    private void verifyTabs() {
        final List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='apps']/a"));

        String[] tabNames = {"Find Patient Record", "Active Visits", "Register a patient",
                "Capture Vitals", "Appointment Scheduling",
                "Reports", "Data Management", "Configure Metadata", "System Administration"};

        int i = 0;
            for (WebElement tab : tabs) {
                final String tabTxt = tab.getText().trim();
                softAssert.assertEquals(tabTxt, tabNames[i]);
                i++;

            }
    }



    private void verifyGeneralTabs() {
        final List<WebElement> tabs = driver.findElements(By.xpath("//ul[@class='navbar-nav ml-auto user-options']/li"));
        String [] tabNames = {"admin", "Impatient Ward", "Logout"};
        int i=0;
        for (String tab : tabNames) {
            softAssert.assertEquals(tab.trim(),tabNames[i]);
            i++;
        }
    }

}











