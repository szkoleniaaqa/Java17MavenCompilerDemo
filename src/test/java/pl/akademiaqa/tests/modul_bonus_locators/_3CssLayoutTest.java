package pl.akademiaqa.tests.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _3CssLayoutTest extends BaseTest {

    @Test
    void css_right_of_test() {
        page.navigate("https://skleptestera.pl/index.php");

//        page.locator("input:right-of(div.js-top-menu a:has-text(\"Art\"))").fill("value");
        page.locator("input:right-of(div.js-top-menu a:has-text(\"Art\"))").first().fill("value");

        page.waitForTimeout(2000);
    }
}
