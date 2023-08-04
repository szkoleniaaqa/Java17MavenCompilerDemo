package pl.akademiaqa.tests.modul_bonus_locators;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

public class _5XpathTest extends BaseTest {

    //https://www.guru99.com/xpath-selenium.html

    @Test
    void xpath_basic_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//input[@name='s']").fill("xpath");

        page.waitForTimeout(2000);
    }

    @Test
    void xpath_contains_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//a[contains(text(), 'Art')]").click();

        page.waitForTimeout(2000);
    }

    @Test
    void xpath_and_or_test() {
        page.navigate("https://skleptestera.pl/index.php");

        page.locator("//li[@class='category' and @id='category-9']").click();

        page.waitForTimeout(2000);
    }

    @Test
    void xpath_starts_with_test() {
        page.navigate("https://skleptestera.pl/index.php");

//        page.locator("//li[starts-with(@class, 'category')]").click();
        page.locator("//li[starts-with(@class, 'category') and @id='category-9' ]").click();


//        Xpath=//label[starts-with(@id,'message')]

        page.waitForTimeout(2000);
    }

    @Test
    void xpath_text_test() {
        page.navigate("https://skleptestera.pl/index.php");
        page.locator("//span[text()='Sign in']").click();
        page.waitForTimeout(2000);
    }
}
