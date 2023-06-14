package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _7VideoRecordingTest extends BaseTest {

    // Nagrywanie video ustawiamy w browserContext

    @Test
    void videoTest() {
        page.navigate("http://localhost:7080/");
        page.getByText("Form Authentication").click();
        page.fill("#username", "tomaszkowalski");
        page.type("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
