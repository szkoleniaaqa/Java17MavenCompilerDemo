package pl.akademiaqa.tests.modul_3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class FirstTest extends BaseTest {

    //Playwright downloads Chromium, WebKit and Firefox browsers into the OS-specific cache folders:
    //* %USERPROFILE%\AppData\Local\ms-playwright on Windows
    //* ~/Library/Caches/ms-playwright on MacOS
    //* ~/.cache/ms-playwright on Linux

    @Test
    void should_return_correct_page_title() {

//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch();
//        Page page = browser.newPage();

        page.navigate("https://playwright.dev/");
        System.out.println(page.title());
        Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }
}
