package pl.akademiaqa.common;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import org.junit.jupiter.api.*;
import pl.akademiaqa.utils.Properties;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseApiTest {

    protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseApiTest.class);

    private Playwright playwright;
    private APIRequest request;
    protected APIRequestContext apiContext;

    @BeforeAll
    void beforeAll() {
        playwright = Playwright.create();
        request = playwright.request();
    }

    @BeforeEach
    void beforeEach() {
        // API
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        apiContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL(Properties.getProperty("app.api.url"))
                .setExtraHTTPHeaders(headers));
    }

    @AfterAll
    void afterAll() {
        playwright.close();
    }
}
