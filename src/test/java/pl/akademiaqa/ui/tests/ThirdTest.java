package pl.akademiaqa.ui.tests;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

public class ThirdTest extends BaseUiTest {

    @Test
    void sample13Test() {
        System.out.println("Third test 1 " + page.title());
    }

    @Test
    void sample23Test() {
        System.out.println("Third test 2 " + page.title());
    }

    @Test
    void sample33Test() {
        System.out.println("Third test 3 " + page.title());
    }
}
