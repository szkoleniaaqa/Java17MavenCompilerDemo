package pl.akademiaqa.tests.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
public class BaseTest {

    private static Playwright pw;
    private static Browser browser;
    private BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    static void beforeAll() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEach() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterEach
    void afterEach() {
        // tu wystarczy zamknać sam context - contexa zamknie wszystkie page
        page.close();
        browserContext.close();
    }

    @AfterAll
    static void afterAll() {
        // tu wystarczy zamknąć samo playwrigth - pw zamknie wszystkie browsery
        browser.close();
        pw.close();
    }
}
