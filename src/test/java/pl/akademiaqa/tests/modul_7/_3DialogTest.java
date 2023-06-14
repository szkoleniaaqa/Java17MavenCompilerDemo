package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class _3DialogTest extends BaseTest {

    // dialogs are dismissed automatically
    // dialogi są automatycznie zwalniane, chyba, że napiszemy handler, i zadecydujemy co chcemy zrobić
    // listener musi być zawsze przed kliknięciem w przycik włączający dialog

    // może być używany jak mamy tylko jeden dialog
    // page.onDialog();

    // musi być używany jak mamy kilka dialogów lub chcemy jeden używać kilka razy.
    // once zwalnia handler po każdym użyciu dialogu
    // page.onceDialog();

    @Test
    void dialogAlertTest() { // OK jest domyślnie
        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");

        Locator alertButton = page.locator("text=Click for JS Alert");
        page.onceDialog(dialog -> dialog.accept());
        alertButton.click();
        assertThat(page.locator("#result").innerText()).isEqualTo("You successfully clicked an alert");
    }

    @Test
    void dialogConfirmTest() { // Cancel jest domyślnie
        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");
        Locator confirmButton = page.locator("text=Click for JS Confirm");

        page.onceDialog(dialog -> dialog.accept());
        confirmButton.click();
        assertThat(page.locator("#result").innerText()).isEqualTo("You clicked: Ok");
//
        page.onceDialog(dialog -> dialog.dismiss());
        confirmButton.click();
        assertThat(page.locator("#result").innerText()).isEqualTo("You clicked: Cancel");
    }

    @Test
    void dialogPromptTest() { // Cancel jest domyślnie
        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");
        Locator promptButton = page.locator("text=Click for JS Prompt");

        page.onceDialog(dialog -> dialog.accept());
        promptButton.click();
        assertThat(page.locator("#result").innerText()).isEqualTo("You entered:");

        page.onceDialog(dialog -> dialog.dismiss());
        promptButton.click();
        assertThat(page.locator("#result").innerText()).isEqualTo("You entered: null");

        page.onceDialog(dialog -> dialog.accept("123"));
        promptButton.click();
        assertThat(page.locator("#result").innerText()).isEqualTo("You entered: 123");
    }
}
