package pl.akademiaqa.tests.modul_4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

class LoginWithValidCredentialsTest extends BaseTest {

    @Test
    void should_login_with_valid_credentials() throws InterruptedException {
        page.navigate("http://the-internet.herokuapp.com/login");
//        page.fill("id=username", "tomsmith");
        // id wspiera różne tagi:
//        Locator inputPassword = page.locator("input").last();
//        inputPassword.fill("tomsmith");
////        page.fill("input", "tomsmith");
//        page.fill("#password", "SuperSecretPassword!");
        page.click("text=Login"); // nic nie klika, włączamy debug
        page.click("#login button"); // nic nie klika, włączamy debug

        Thread.sleep(3000);
    }
}
