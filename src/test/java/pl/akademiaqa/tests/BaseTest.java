package pl.akademiaqa.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        browser = playwright.chromium().launch();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1080);
        page.navigate("http://automationpractice.pl/index.php");
    }

    @AfterEach
    void closeContext() {
        // tu wystarczy zamknać sam context - contexa zamknie wszystkie page
        // page.close();
        context.close();
    }

    @AfterAll
    void closeBrowser() {
        // tu wystarczy zamknąć samo playwrigth - pw zamknie wszystkie browsery
        // browser.close();
        playwright.close();
    }
}
