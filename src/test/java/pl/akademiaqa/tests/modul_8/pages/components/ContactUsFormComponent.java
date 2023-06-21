package pl.akademiaqa.tests.modul_8.pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.tests.modul_8.dto.ContactUsDTO;
import pl.akademiaqa.tests.modul_8.pages.locators.ContactUsFormLocators;

import java.nio.file.Paths;

public class
ContactUsFormComponent {
    private ContactUsFormLocators locators;

    // KONSTRUKTOR
    public ContactUsFormComponent(Page page) {
        this.locators = new ContactUsFormLocators(page);
    }

    // LOKATORY
    public ContactUsFormLocators getLocators() {
        return locators;
    }

    // AKCJE
    public void clickSendMessageButton() {
        locators.sendMessageButton().click();
    }

    public void selectSubjectHeading(String option) {
        locators.subjectHeading().selectOption(option);
    }

    public void enterEmailAddress(String email) {
        locators.emailAddressInput().fill(email);
    }

    public void enterOrderReference(String orderReference) {
        locators.orderReferenceInput().fill(orderReference);
    }

    public void selectFileToUpload(String filePath) {
        locators.fileUploadInput().setInputFiles(Paths.get(filePath));
    }

    public void enterMessage(String message) {
        locators.messageText().fill(message);
    }

    public void sendContactUsForm(ContactUsDTO contactUsDTO) {
        selectSubjectHeading(contactUsDTO.getSubjectHeading());
        enterEmailAddress(contactUsDTO.getEmailAddress());
        enterOrderReference(contactUsDTO.getOrderReference());
        selectFileToUpload(contactUsDTO.getFileToUpload());
        enterMessage(contactUsDTO.getMessage());
        clickSendMessageButton();
    }
}
