package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import java.util.Arrays;

class _1PageTest extends BaseTest {

//    private final String URL = "http://the-internet.herokuapp.com/context_menu";
    private final String URL = "http://localhost:7080/inputs";

    @Test
    void pageTest() {

//        page.navigate(URL);
//
//        page.navigate(URL, new Page.NavigateOptions().setTimeout(10000)); //30 sek domyślnie,  0 wyłącza czekanie
//
//        page.navigate(URL, new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));
        // LOAD - DEFAULT
        // DOMCONTENTLOADED - szybsza opcja od LOAD, może być zz szybka i nie jest rekomendowana.
        // Jeżeli chcesz sprawdzić tylko page title to powinna być wystarczająca
        // NETWORKIDLE,
        // COMMIT;

        // 1. DOMCONTENTLOADED - html jest załadowany, ale css i js jeszcze nie
        // DOMContentLoaded. Zdarzenie DOMContentLoaded zachodzi wówczas, gdy przeglądarka załaduje wszystkie elementy DOM strony internetowej.
        // 2. LOAD - html jest załadowany oraz css i js są już załadowane
        // 3. NETWORKIDLE - stan, w którym nie ma już żadnych dodatkowych requestów przez 500 ms

//        When to consider operation succeeded, defaults to load. Events can be either:
//        'domcontentloaded' - consider operation to be finished when the DOMContentLoaded event is fired.
//        'load' - consider operation to be finished when the load event is fired.
//        'networkidle' - DISCOURAGED consider operation to be finished when there are no network connections for at least 500 ms. Don't use this method for testing, rely on web assertions to assess readiness instead.
//        'commit' - consider operation to be finished when network response is received and the document started loading.

        //Referrer (ang. refer — odsyłać) — adres witryny internetowej, z której użytkownik został przekierowany przy pomocy odnośnika. Referrer jest przekazywany w nagłówku żądania HTTP.
//        page.navigate(URL, new Page.NavigateOptions().setReferer("https://onet.pl"));
//
//        page.reload();
//        page.reload(new Page.ReloadOptions().setTimeout(10000));
//        page.goBack();
//        page.goBack(new Page.GoBackOptions().setTimeout(10000));
//        page.goForward();
//        page.goForward(new Page.GoForwardOptions().setTimeout(10000));
//
//        page.click("");
//        page.click("", new Page.ClickOptions().setClickCount(10)); // dodanie 10 elementów do koszyka
        page.navigate(URL);
        page.getByRole(AriaRole.SPINBUTTON).fill("10");
        page.keyboard().press("ArrowUp");
        page.keyboard().press("ArrowUp");
        page.keyboard().press("ArrowUp");
        page.keyboard().press("ArrowUp");
        page.keyboard().press("ArrowUp");
        page.pause();

//        page.click("", new Page.ClickOptions().setButton(MouseButton.RIGHT));
//        page.click("", new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL, KeyboardModifier.ALT)));
//        page.dblclick("");
//        page.click("", new Page.ClickOptions().setForce(true)); // omija sprawdzenia czy element jest widoczny i klikany
//        page.check("", new Page.CheckOptions());
//        page.uncheck("", new Page.UncheckOptions());

//        page.navigate(URL);
//        page.locator("#hot-spot")
//                .click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }
}
