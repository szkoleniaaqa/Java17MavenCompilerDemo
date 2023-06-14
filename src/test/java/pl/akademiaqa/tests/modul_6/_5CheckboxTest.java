package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _5CheckboxTest extends BaseTest {

    @Test
    void checkboxTest(){
        page.navigate("http://the-internet.herokuapp.com/checkboxes");
        page.getByRole(AriaRole.CHECKBOX).first().check();
        page.getByRole(AriaRole.CHECKBOX).last().uncheck();
    }
}
