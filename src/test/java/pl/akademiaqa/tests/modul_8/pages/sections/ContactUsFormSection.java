package pl.akademiaqa.tests.modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.tests.modul_8.dto.ContactUsDTO;
import pl.akademiaqa.tests.modul_8.pages.BasePage;

import java.nio.file.Paths;

@Getter
public class ContactUsFormSection extends BasePage {

    private Locator confirmationMessage;
    private Locator sendMessageButton;
    private Locator errorMessage;
    private Locator subjectHeading;
    private Locator emailAddressInput;
    private Locator orderReferenceInput;
    private Locator fileUploadInput;
    private Locator messageText;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendMessageButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
        this.subjectHeading = page.locator("#id_contact");
        this.emailAddressInput = page.getByLabel("Email address");
        this.orderReferenceInput = page.locator("#id_order");
        this.fileUploadInput = page.locator("#fileUpload");
        this.messageText = page.locator("#message");
        this.confirmationMessage = page.getByText("Your message has been successfully sent to our team.");
    }

    // AKCJE
    public void clickSendMessageButton() {
        sendMessageButton.click();
    }

    public void selectSubjectHeading(String option) {
        subjectHeading.selectOption(option);
    }

    public void enterEmailAddress(String email) {
        emailAddressInput.fill(email);
    }

    public void enterOrderReference(String orderReference) {
        orderReferenceInput.fill(orderReference);
    }

    public void selectFileToUpload(String filePath) {
        fileUploadInput.setInputFiles(Paths.get(filePath));
    }

    public void enterMessage(String message) {
        messageText.fill(message);
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
