package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _6AssertionsTest extends BaseTest {


    @Test
    void assertionsTest() {
        // https://playwright.dev/java/docs/test-assertions

        page.navigate("http://the-internet.herokuapp.com/checkboxes");

        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        PlaywrightAssertions.assertThat(firstCheckbox).not().isChecked();
        firstCheckbox.check();
        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();

        Locator lastCheckbox = page.getByRole(AriaRole.CHECKBOX).last();
        PlaywrightAssertions.assertThat(lastCheckbox).isChecked();
        lastCheckbox.uncheck();
        PlaywrightAssertions.assertThat(lastCheckbox).not().isChecked();
    }
}
