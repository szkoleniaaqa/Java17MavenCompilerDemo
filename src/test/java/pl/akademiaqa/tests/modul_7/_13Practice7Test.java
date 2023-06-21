package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import java.nio.file.Paths;
import java.util.List;

class _13Practice7Test extends BaseTest {

    // Wysłać pusty formularz i zrobić screena z błędu.
    // Utworzyć do tego tracing
    @Test
    void should_show_an_error_when_trying_to_send_empty_form() {
        page.navigate("http://www.automationpractice.pl/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#submitMessage").click();

        page.locator("#center_column").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/empty_contact_us_form.png")));

        PlaywrightAssertions.assertThat(page.getByText("Invalid email address.")).isVisible();
    }



    // Wypełnić i wysłać formularz contact us
    // Utworzyć do tego tracing
    @Test
    void should_fill_and_send_contact_us_form() {
        page.navigate("http://www.automationpractice.pl/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
        page.selectOption("#id_contact", "Webmaster");
        page.getByLabel("Email address").fill("demo@demo.com");
        page.locator("#id_order").fill("12345");
        page.setInputFiles("#fileUpload", Paths.get("upload/zakaz_wjazdu_2.jpeg"));
        page.locator("#message").fill("This is test message");
        page.locator("#submitMessage").click();

        PlaywrightAssertions.assertThat(page.getByText("Your message has been successfully sent to our team.")).isVisible();
    }
}
