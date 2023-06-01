package pl.akademiaqa.ui.tests.login;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LoginWithInvalidCredentialsTest extends BaseUiTest {

    @Test
    void should_show_error_when_login_with_invalid_credentials() {
        page.locator("text=Form Authentication").click();
        assertThat(page.locator("text=Login Page")).isVisible();
        page.locator("#username").fill("username");
        page.locator("#password").fill("password!");
        page.locator("#login button").click();
        assertThat(page.locator("text=Your username is invalid!")).isVisible();
    }
}
