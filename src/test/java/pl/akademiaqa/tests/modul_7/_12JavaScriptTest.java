package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _12JavaScriptTest extends BaseTest {

    // https://developer.mozilla.org/en-US/docs/Web/API/Window

    @Test
    void evaluateTest() {
        page.navigate("http://localhost:7080/");
        String window = (String) page.evaluate("() => window.origin");
        System.out.println("WindowInfo: " + window);
    }

    @Test
    void evalOnSelectorTest() {
        page.navigate("http://localhost:7080/");
        Assertions.assertThat(page.locator("h1[class=heading]").isVisible()).isTrue();
        page.evalOnSelector("h1[class=heading]", "e => e.remove()");
        page.waitForTimeout(2000);
        Assertions.assertThat(page.locator("h1[class=heading]").isVisible()).isFalse();
    }

    @Test
    void evalOnSelectorAllTest() {
        page.navigate("http://localhost:7080/");
        Integer numberOfLinks = (Integer) page.evalOnSelectorAll("ul li", "e => e.length");
        Assertions.assertThat(numberOfLinks).isEqualTo(44);
    }
}
