package pl.akademiaqa.tests.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _4NthMatchTest extends BaseTest {

    @Test
    void css_nth_match_test() {
        page.navigate("https://skleptestera.pl/index.php");

//        page.locator("input:visible").fill("value");
//        page.locator("input:visible").fill("value");

        // index od 1
        page.locator(":nth-match(input:visible, 1)").fill("szukany text");

        page.waitForTimeout(2000);
    }

    @Test
    void css_nth_element_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("input:visible").locator("nth=0").fill("szukany text");

        page.waitForTimeout(2000);
    }


}
