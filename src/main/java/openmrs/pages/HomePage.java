package openmrs.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import openmrs.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends CommonPage {


    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    private WebElement findPatientTab;

    @FindBy(id = "org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")
    private WebElement activeVisitsTab;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
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


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void visitHomePage() {
        driver.get(ConfigReader.getProperty("urlHomePage"));

        Assert.assertEquals(driver.getTitle(), "Home");      // verify the title of the page
    }


    private void selectTab() {
        verifyTabs();

        //select location Register A Patient
        registerPatientTab.click();
        Assert.assertTrue(registerPatientTab.isEnabled());

    }


    private void verifyTabs() {
        final List<WebElement> tabs = driver.findElements(By.xpath("//div[@class='col-12 col-sm-12 col-md-12 col-lg-12 homeList']/a"));
        for (WebElement tab : tabs)
            Assert.assertTrue(tab.isDisplayed());
    }
}






