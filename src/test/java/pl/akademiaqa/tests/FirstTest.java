package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {

    @Test
    void sample1Test() {
        System.out.println("First test 1 " + page.title());
    }

    @Test
    void sample2Test() {
        System.out.println("First test 2 " + page.title());
    }

    @Test
    void sample3Test() {
        System.out.println("First test 3 " + page.title());
    }

//    @Test
//    void sample3Test() {
//        System.out.println(page.title());
//    }
//
//    @Test
//    void sample4Test() {
//        System.out.println(page.title());
//    }
//
//    @Test
//    void sample5Test() {
//        System.out.println(page.title());
//    }
//
//    @Test
//    void sample6Test() {
//        System.out.println(page.title());
//    }
//
//    @Test
//    void sample7Test() {
//        System.out.println(page.title());
//    }
//
//    @Test
//    void sample8Test() {
//        System.out.println(page.title());
//    }
//
//    @Test
//    void sample9Test() {
//        System.out.println(page.title());
//    }
}
