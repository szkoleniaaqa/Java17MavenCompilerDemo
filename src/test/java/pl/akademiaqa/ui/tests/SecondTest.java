package pl.akademiaqa.ui.tests;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

public class SecondTest extends BaseUiTest {

    @Test
    void sample21Test() {
        System.out.println("Second test 1 " + page.title());
    }

    @Test
    void sample22Test() {
        System.out.println("Second test 2 " + page.title());
    }

    @Test
    void sample23Test() {
        System.out.println("Second test 3 " + page.title());
    }
}
