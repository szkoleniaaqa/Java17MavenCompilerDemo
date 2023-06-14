package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class _9BasicAuthTest extends BaseTest {

    @Test
    void basicAuthTest() {
        page.navigate("http://localhost:7080/basic_auth");
        assertThat(page.getByText("Congratulations! You must have the proper credentials.")).isVisible();
    }
}
