package pl.akademiaqa.tests.modul_8;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;
import pl.akademiaqa.tests.modul_8.pages.CreateAnAccountPage;
import pl.akademiaqa.tests.modul_8.pages.HomePage;
import pl.akademiaqa.tests.modul_8.pages.sections.CreateAnAccountFormSection;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class CreateAnAccountTest extends BaseTest {

    private HomePage homePage;
    private Faker faker;

    @BeforeEach
    void beforeEach() {
        faker = new Faker();
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/");
    }

    @Test
    void should_create_new_account() {
        CreateAnAccountPage createAnAccountPage = homePage.getTopMenuSection().clickSignInLink();

        createAnAccountPage.getCreateAnAccountFormSection()
                .enterEmail(faker.internet().emailAddress())
                .clickCreateAnAccountButton();

        createAnAccountPage.getCreateAnAccountFormSection()
                .checkGenderMr()
                .enterFirstName("Janek")
                .enterLastName("Kowalski")
                .enterPassword("123456")
                .setDateOfBirth("6", "6", "2000")
                .clickRegisterButton();

        assertThat(page.getByText("Your account has been created.")).isVisible();
        assertThat(page.locator("h1[class=page-heading]")).hasText("My account");
    }
}
