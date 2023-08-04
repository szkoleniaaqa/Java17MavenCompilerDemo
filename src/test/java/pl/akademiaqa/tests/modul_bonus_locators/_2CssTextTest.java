package pl.akademiaqa.tests.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _2CssTextTest extends BaseTest {

    @Test
    void css_by_has_text_test(){
        page.navigate("https://skleptestera.pl/index.php");

//        page.locator("a:has-text(\"Art\")").click();
        page.locator("div.js-top-menu a:has-text(\"Art\")").click();
        page.waitForTimeout(2000);
    }

    @Test
    void css_by_text_test(){
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("div.js-top-menu :text(\"Art\")").click();

        page.waitForTimeout(2000);
    }

    @Test
    void css_by_text_is_test(){
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("div.js-top-menu :text-is(\"Accessories\")").click();

        page.waitForTimeout(2000);
    }

    @Test
    void css_containing_other_elements_test(){
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("li.category:has(a:has-text(\"Art\"))").click();

        page.waitForTimeout(2000);
    }
}
