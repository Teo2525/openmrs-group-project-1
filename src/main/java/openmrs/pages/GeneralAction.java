package openmrs.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import openmrs.pages.RegistrationPage;

import java.util.List;

public class GeneralAction {
    private WebDriver driver;
    private SoftAssert softAssert;
    private Faker faker;
//public static RegistrationPage registrationPage = new RegistrationPage();


    public GeneralAction(WebDriver driver,SoftAssert softAssert){
        this.driver=driver;
        this.faker=new Faker();
        this.softAssert=softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id='content']/div[9]/div[2]/div/ul")
    private List<WebElement> generalAction;

    @FindBy(xpath = "//*[@id='TextField']/pre/i")
    private WebElement patientNote;

    @FindBy(xpath = "//*[@id='coreapps-fragment-stickyNote']/coreapps-click-to-edit-obs/div/div/div[1]/span[1]/form/div/textarea")
    private WebElement enterNote;

    @FindBy(xpath = "//*[@id='coreapps-fragment-stickyNote']/coreapps-click-to-edit-obs/div/div/div[1]/span[1]/form/div/span/button[1]/span")
    private WebElement saveNote;

    @FindBy(xpath = "/html/body/header/nav/div[1]/a/img")
    private WebElement homePage;

    @FindBy(id = "/html/body/header/nav/div[1]/a/img")
    private WebElement findPatientRecord;

    @FindBy(xpath = "/html/body/div[2]/div/div/p")
    private WebElement popUpSaved;

    @FindBy(id = "patient-search")
    private WebElement searchId;


    public void verifyGeneralAction() throws InterruptedException {
        String[] generalActionName = {"Start Visit", "Add Past Visit", "Merge Visits", "Schedule Appointment", "Request Appointment ", "Mark Patient Deceased", "Edit Registration Information", "Delete Patient", "Attachments"};
        for (int i = 0; i < generalAction.size(); i++) {
            softAssert.assertEquals(generalAction.get(i).getText().trim(), generalActionName[i]);


        }
        //int i = 0;
//       for (WebElement list : lists) {
//            softAssert.assertEquals(list.getText().trim(), generalActionName[i]);
//            i++;
    }

    public void createNote() throws InterruptedException {
        patientNote.click();
        Thread.sleep(500);
        enterNote.sendKeys("this is the test");
        saveNote.click();
        String text = popUpSaved.getText();
        softAssert.assertEquals(text.trim(), "Patient note successfully saved");

    }

    public void backToHomePage() throws InterruptedException {
        homePage.click();
        Thread.sleep(500);
        findPatientRecord.click();

        ///searchId.sendKeys(registrationPage.)
    }


}



