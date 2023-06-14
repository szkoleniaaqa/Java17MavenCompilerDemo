package pl.akademiaqa.tests.modul_6;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

class _3TextTest extends BaseTest {

    @Test
    void textTest(){
        page.navigate("http://localhost:7080/notification_message_rendered");
//        System.out.println(page.innerHTML("#content"));
        // 1 .innerHTML() - tags + text

//        System.out.println(page.innerText("#content"));
        // 2 .innerText() - sam text (text widoczny dla człowieka)

//        System.out.println(page.textContent("#content"));
        // 3 .textContent() - sam text, widoczny i niewidoczny (np: <span display:none>hidden)

//        System.out.println(page.getAttribute("div img", "alt"));
//         4 .getAttribute() - atrybuty elementów html
    }
}
