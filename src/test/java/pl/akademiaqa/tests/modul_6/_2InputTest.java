package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

class _2InputTest extends BaseTest {

    @Test
    void inputTest() {
        page.navigate("http://the-internet.herokuapp.com/login");
        page.fill("#username", "tomaszkowalski");
        page.type("#password", "haslo123");
    }
}
