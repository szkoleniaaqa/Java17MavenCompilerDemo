package pl.akademiaqa.tests.modul_7;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _2ShadowDOMTest extends BaseTest {

    // Page -> DOM -> Shadow DOM -> elements

    @Test
    void shadowDOMTest() {
        page.navigate("http://the-internet.herokuapp.com/shadowdom");
        System.out.println(page.locator("span[slot=my-text]").textContent());
    }

    @Test
    void shadowDOMTest2() {
        page.navigate("https://bugs.chromium.org/p/chromium/issues/list");
        page.selectOption("#can", "New issues");
        page.waitForTimeout(3000);
    }
}
