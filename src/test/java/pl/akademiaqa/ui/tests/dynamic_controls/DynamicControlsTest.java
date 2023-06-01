package pl.akademiaqa.ui.tests.dynamic_controls;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DynamicControlsTest extends BaseUiTest {

    @Test
    void should_enable_input() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dynamic Controls")).click();
        assertThat(page.locator("#input-example input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        assertThat(page.locator("#input-example input[type=text]")).isEnabled();
    }

    @Test
    void should_remove_checkbox() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dynamic Controls")).click();
        assertThat(page.locator("#checkbox")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();
        assertThat(page.locator("#checkbox")).not().isVisible();
        page.getByText("it's gone!").isVisible();
    }
}
