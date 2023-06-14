package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

class _4DropdownTest extends BaseTest {

    @Test
    void dropdownTest() {
        page.navigate("http://localhost:7080/dropdown");
        page.selectOption("#dropdown", "2"); // value albo
        page.selectOption("#dropdown", "Option 2"); // wartość
    }

    @Test
    void multiselectTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[] {"ms3", "ms4"});
    }
}
