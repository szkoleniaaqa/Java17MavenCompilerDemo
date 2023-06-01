package pl.akademiaqa.ui.tests.playwright_basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

    public static void main(String[] args) {

//        PRZEGLĄDARKI:
//        Playwright downloads Chromium, WebKit and Firefox browsers into the OS -specific cache folders:
//        %USERPROFILE %\AppData\Local\ms - playwright on Windows
//        ~ / Library / Caches / ms - playwright on MacOS
//        ~ /.cache / ms - playwright on Linux

        // 1. Tworzymy serwer Playwright
        Playwright playwright = Playwright.create();

        // 2. Tworzymy przeglądarkę
//        Browser browser = playwright.chromium().launch();
        // Tu się powinny ściągnąć binarki przeglądarek
        // Uruchomić 2gi raz i pokazać, że już się nie ściągają
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
//        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
//        // SAFARI
//        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                .setChannel("chrome")
//                .setHeadless(false)
//                .setSlowMo(2000));

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("msedge")
                .setHeadless(false)
                .setSlowMo(2000));

        // 3. Tworzymy stronę
        Page page = browser.newPage();

        // 4. Otwieramy adres WWW
        page.navigate("https://www.whatismybrowser.com/");

        // 5. Wyświetlamy adres strony
        System.out.println(page.title());

        // 6. Zamykamy przeglądarkę
        browser.close();

        // Zamykamy serwer playwright
        playwright.close();
    }
}
