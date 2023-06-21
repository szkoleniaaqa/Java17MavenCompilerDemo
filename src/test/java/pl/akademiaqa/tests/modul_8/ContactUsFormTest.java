package pl.akademiaqa.tests.modul_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;
import pl.akademiaqa.tests.modul_8.dto.ContactUsDTO;
import pl.akademiaqa.tests.modul_8.pages.ContactUsPage;
import pl.akademiaqa.tests.modul_8.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class ContactUsFormTest extends BaseTest {

    private HomePage homePage;

//    private TopMenuComponent topMenuBarPage;
//    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
//        topMenuBarPage = new TopMenuComponent(page);
//        contactUsFormPage = new ContactUsFormPage(page);

        page.navigate("http://www.automationpractice.pl/");
    }

//    @Test
//    void should_show_an_error_when_trying_to_send_empty_form() {
//        topMenuBarPage.clickContactUsLink();
//        contactUsFormPage.clickSendMessageButton();
//        assertThat(contactUsFormPage.getLocators().errorMessage()).isVisible();
//    }

    // PRZEROBIONY
    @Test
    void should_show_an_error_when_trying_to_send_empty_form() {
        ContactUsPage contactUsPage = homePage.getTopMenuComponent().clickContactUsLink();
        contactUsPage.getContactUsFormComponent().clickSendMessageButton();
        assertThat(contactUsPage.getContactUsFormComponent().getLocators().errorMessage()).isVisible();
    }


//    @Test
//    void should_fill_and_send_contact_us_form() {
//        topMenuBarPage.clickContactUsLink();
//
//        // KROK 1
////        contactUsFormPage.selectSubjectHeading("Webmaster");
////        contactUsFormPage.enterEmailAddress("demo@demo.com");
////        contactUsFormPage.enterOrderReference("12345");
////        contactUsFormPage.selectFileToUpload("upload/zakaz_wjazdu_2.jpeg");
////        contactUsFormPage.enterMessage("This is sample message");
////        contactUsFormPage.clickSendMessageButton();
//
//        // KROK 3
////        ContactUsDTO defaultContactUsDTO = ContactUsDTO.getDefaultContactUsDTO();
////        defaultContactUsDTO.setEmailAddress("");
//
//        // KROK 2
//        contactUsFormPage.sendContactUsForm(ContactUsDTO.getDefaultContactUsDTO());
//        assertThat(contactUsFormPage.getLocators().confirmationMessage()).isVisible();
//    }

    @Test
    void should_fill_and_send_contact_us_form_1() {
        ContactUsPage contactUsPage = homePage.getTopMenuComponent().clickContactUsLink();
        contactUsPage.getContactUsFormComponent().sendContactUsForm(ContactUsDTO.getDefaultContactUsDTO());
        assertThat(contactUsPage.getContactUsFormComponent().getLocators().confirmationMessage()).isVisible();
    }
}
