package pl.akademiaqa.tests.modul_8.pages.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContactUsFormLocators {

    private final Page page;

    public Locator sendMessageButton() {
        return page.locator("#submitMessage");
    }

    public Locator errorMessage() {
        return page.getByText("Invalid email address.");
    }

    public Locator subjectHeading() {
        return page.locator("#id_contact");
    }

    public Locator emailAddressInput() {
        return page.getByLabel("Email address");
    }

    public Locator orderReferenceInput() {
        return page.locator("#id_order");
    }

    public Locator fileUploadInput() {
        return page.locator("#fileUpload");
    }

    public Locator messageText() {
        return page.locator("#message");
    }

    public Locator confirmationMessage() {
        return page.getByText("Your message has been successfully sent to our team.");
    }
}
