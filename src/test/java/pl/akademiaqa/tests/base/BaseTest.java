package pl.akademiaqa.tests.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pl.akademiaqa.utils.Properties;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pl.akademiaqa.utils.StringUtils.removeRoundBrackets;

public class BaseTest {

    private static Playwright pw;
    protected static Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    static void beforeAll() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        browserContext = browser.newContext();

        // BASIC AUTH
//        browserContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));

        // TRACING START
//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));

        // NAGRYWANIE WIDEO Z TESTU
//        browserContext = browser.newContext(new Browser.NewContextOptions()
//                .setViewportSize(1920, 1080)
//                .setRecordVideoDir(Paths.get("videos/"))
//                .setRecordVideoSize(new RecordVideoSize(1920, 1080)));
        page = browserContext.newPage();
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        // tu wystarczy zamknać sam context - context zamknie wszystkie page
//        page.close();

        // TRACING STOP
//        String traceName = "traces/trace_"
//                + removeRoundBrackets(testInfo.getDisplayName())
//                + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".zip";
//        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));

        browserContext.close();
    }

    @AfterAll
    static void afterAll() {
        // tu wystarczy zamknąć samo playwrigth - pw zamknie wszystkie browsery
        browser.close();
        pw.close();
    }
}
