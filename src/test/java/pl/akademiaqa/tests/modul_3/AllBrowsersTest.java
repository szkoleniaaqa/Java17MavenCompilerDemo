package pl.akademiaqa.tests.modul_3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class AllBrowsersTest {

    @Test
    void should_open_supported_browsers() {
        Playwright pw = Playwright.create();
        List<BrowserType> browsers = List.of(pw.chromium(), pw.firefox(), pw.webkit());

        for (BrowserType browserType : browsers) {
            Browser browser = browserType.launch();
            Page page = browser.newPage();
            page.navigate("https://www.whatsmybrowser.org/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + browserType.name() + ".png")));
        }
    }
}
