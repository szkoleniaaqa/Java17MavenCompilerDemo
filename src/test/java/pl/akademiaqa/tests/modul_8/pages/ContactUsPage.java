package pl.akademiaqa.tests.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.tests.modul_8.pages.sections.ContactUsFormSection;
import pl.akademiaqa.tests.modul_8.pages.sections.TopMenuSection;

@Getter
public class ContactUsPage extends BasePage {

    private ContactUsFormSection contactUsFormSection;

    public ContactUsPage(Page page) {
        super(page);
        this.contactUsFormSection = new ContactUsFormSection(page);
    }
}
