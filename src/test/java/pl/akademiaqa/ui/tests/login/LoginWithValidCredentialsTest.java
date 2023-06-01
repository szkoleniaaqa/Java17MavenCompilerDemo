package pl.akademiaqa.ui.tests.login;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginWithValidCredentialsTest extends BaseUiTest {

    @Test
    void should_login_with_valid_credentials_1() {
        page.locator("text=form authentication").click();
        assertThat(page.locator("text=Login Page")).isVisible();
        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("#login button").click();
        assertThat(page.locator("//h2[contains(text(), 'Secure Area')]")).isVisible();
        assertThat(page.locator("text=You logged into a secure area!")).isVisible();
        page.locator("//i[contains(text(), 'Logout')]").click();
        assertThat(page.locator("text=Login Page")).isVisible();
    }

    @Test
    void should_login_with_valid_credentials_2() {
        Path path = Paths.get("screenshots/login.png");
        Locator form_authentication = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication"));
        form_authentication.screenshot(new Locator.ScreenshotOptions().setPath(path));
        form_authentication.click();

        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Login Page"))).isVisible();
    }
}
