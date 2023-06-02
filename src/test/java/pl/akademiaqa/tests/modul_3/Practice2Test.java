package pl.akademiaqa.tests.modul_3;

import com.microsoft.playwright.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class Practice2Test {

    @Test
    void should_verify_onet_page_title(){

        Playwright pw = Playwright.create();
        Browser browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();


        page.navigate("https://onet.pl");
        Assertions.assertThat(page.title()).isEqualTo("Onet – Jesteś na bieżąco");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/onet.png")));
    }
}
