package pl.akademiaqa.tests;

import org.junit.jupiter.api.Test;

public class SecondTest extends BaseTest {

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
