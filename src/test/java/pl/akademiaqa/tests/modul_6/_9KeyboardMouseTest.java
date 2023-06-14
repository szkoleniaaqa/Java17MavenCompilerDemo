package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _9KeyboardMouseTest extends BaseTest {

    @Test
    void keyboardTest() {

        // KEYBOARD - https://playwright.dev/java/docs/api/class-keyboard

        page.navigate("http://the-internet.herokuapp.com/key_presses");
//        page.click("#target");
//        Keyboard keyboard = page.keyboard();
//        keyboard.press("ArrowUp");
//        PlaywrightAssertions.assertThat(page.getByText("You entered: UP")).isVisible();

        // Zaznaczenie całej strony Ctrl + A
        // on Windows and Linux
        // page.keyboard().press("Control+A");
        // on macOS
        // page.keyboard().press("Meta+A");
    }

    @Test
    void mouseTest() {
//         MOUSE - https://playwright.dev/java/docs/api/class-mouse
        page.navigate("http://the-internet.herokuapp.com/context_menu");
        Locator hotSpot = page.locator("#hot-spot");
//        hotSpot.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
        page.hover("#hot-spot");

        Mouse mouse = page.mouse();
        mouse.click(200,300, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));
    }

    @Test
    void dragAndDropTest() {
        page.navigate("http://the-internet.herokuapp.com/drag_and_drop");
        Locator colA = page.locator("#column-a");
        Locator colB = page.locator("#column-b");
        colA.dragTo(colB);
    }
}
