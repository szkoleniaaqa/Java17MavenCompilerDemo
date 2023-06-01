package pl.akademiaqa.ui.tests.login;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LoginWithEmptyCredentialsTest extends BaseUiTest {

    @Test
    void should_show_error_when_login_with_empty_form() {
        page.locator("text=Form Authentication").click();
        page.locator("#login button").click();
        assertThat(page.locator("text=Your username is invalid!")).isVisible();
    }

    @Test
    void should_show_error_when_login_with_empty_username() {
        page.locator("text=Form Authentication").click();
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("#login button").click();
        assertThat(page.locator("text=Your username is invalid!")).isVisible();
    }

    @Test
    void should_show_error_when_login_with_empty_password() {
        page.locator("text=Form Authentication").click();
        page.locator("#username").fill("tomsmith");
        page.locator("#login button").click();
        assertThat(page.locator("text=Your password is invalid!")).isVisible();
    }
}
