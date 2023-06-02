package pl.akademiaqa.common;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pl.akademiaqa.factory.BrowserFactory;
import pl.akademiaqa.utils.Properties;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pl.akademiaqa.utils.StringUtils.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseUiTest {

    private BrowserFactory browserFactory;
    private Browser browser;
    private BrowserContext context;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        browserFactory = new BrowserFactory();
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
////        browser = playwright.chromium().launch();
        browser = browserFactory.getBrowser();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        if (isTracingEnabled()) {
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
        page = context.newPage();
        page.setViewportSize(1920, 1080);
//        page.route("**/*.{png,jpg,jpeg,svg}", route -> route.abort());
        page.navigate(Properties.getProperty("app.ui.url"));
//        page.pause();
    }

    @AfterEach
    void closeContext(TestInfo testInfo) {
        // tu wystarczy zamknać sam context - contexa zamknie wszystkie page
        // page.close();
        if (isTracingEnabled()) {
            String traceName = "traces/trace_"
                    + removeRoundBrackets(testInfo.getDisplayName())
                    + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(Properties.getProperty("app.tracing.date.format"))) + ".zip";
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        }
        context.close();
    }

    @AfterAll
    void closeBrowser() {
        // tu wystarczy zamknąć samo playwrigth - pw zamknie wszystkie browsery
        // browser.close();
        browserFactory.getPlaywright().close();
    }

    private boolean isTracingEnabled() {
        return Properties.getProperty("app.tracing.enabled").equalsIgnoreCase("true");
    }

    //        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(2000));
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(2000));
}
