package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _2InputTest extends BaseTest {

    @Test
    void inputTest() {
        // fill // wklejenie całego textu, fill czyści wartość, jeżeli coś jest już tam wpisane
        // type // wpisanie znak po znaku - nie czyści poprzedniej zawartości
        // jeżeli mamy stronę, która wyszukuje po wpisanym znaku to używamy type
        // page.fill("", "wartość");
        // page.fill("", "wartość", new Page.FillOptions().setForce(true)); // nie wpisze do pola, które jest wyłączone (disabled)


        page.navigate("http://the-internet.herokuapp.com/login");
        page.fill("#username", "tomaszkowalski");
        page.type("#password", "haslo123");

        page.waitForTimeout(3000);
    }
}
