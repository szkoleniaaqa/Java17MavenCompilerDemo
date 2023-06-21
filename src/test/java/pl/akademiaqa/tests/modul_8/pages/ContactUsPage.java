package pl.akademiaqa.tests.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.tests.modul_8.pages.components.ContactUsFormComponent;

public class ContactUsPage extends BasePage {

    @Getter
    private ContactUsFormComponent contactUsFormComponent;

    public ContactUsPage(Page page) {
        super(page);
        this.contactUsFormComponent = new ContactUsFormComponent(page);
    }
}
