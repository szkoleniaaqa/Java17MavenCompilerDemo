package pl.akademiaqa.tests.modul_8.pages.components;

import com.microsoft.playwright.Page;
import pl.akademiaqa.tests.modul_8.pages.ContactUsPage;
import pl.akademiaqa.tests.modul_8.pages.CreateAnAccountPage;
import pl.akademiaqa.tests.modul_8.pages.locators.TopMenuLocators;

public class TopMenuComponent {

    private Page page;

    private TopMenuLocators locators;

    // KONSTRUKTOR
    public TopMenuComponent(Page page) {
        this.page = page;
        this.locators = new TopMenuLocators(page);
    }

    // LOKATORY
    public TopMenuLocators getLocators() {
        return locators;
    }

    // AKCJE
//    public void clickContactUsLink() {
//        locators.contactUsLink().click();
//    }

    public ContactUsPage clickContactUsLink() {
        locators.contactUsLink().click();
        return new ContactUsPage(page);
    }

    public CreateAnAccountPage clickSignInLink() {
        locators.signInLink().click();
        return new CreateAnAccountPage(page);
    }
}
