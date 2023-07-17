package pl.akademiaqa.tests.modul_15_komunikacja_http;

import com.microsoft.playwright.Response;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

public class HttpCommunicationTest extends BaseUiTest {


    @Test
    void should_send_http_request_test() {
        final var response = page.navigate("https://skleptestera.pl");
        System.out.println(response.url());
    }
}
