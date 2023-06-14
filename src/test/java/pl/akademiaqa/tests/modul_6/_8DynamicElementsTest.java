package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _8DynamicElementsTest extends BaseTest {


    // AUTO-WAITING - https://playwright.dev/java/docs/actionability

    @Test
    void dynamicElementTest1(){
        page.navigate("http://the-internet.herokuapp.com/dynamic_loading/1");
        Locator helloText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(helloText).not().isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(helloText).isVisible();
    }

    @Test
    void dynamicElementTest2(){
        page.navigate("http://the-internet.herokuapp.com/dynamic_loading/2");
        Locator helloText = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(helloText).not().isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(helloText).isVisible();
    }

    @Test
    void dynamicControlsTest1(){
        page.navigate("http://the-internet.herokuapp.com/dynamic_controls");
        assertThat(page.locator("#checkbox")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();
        assertThat(page.locator("#checkbox")).not().isVisible();
        page.getByText("it's gone!").isVisible();
    }

    @Test
    void dynamicControlsTest2() {
        page.navigate("http://the-internet.herokuapp.com/dynamic_controls");
        assertThat(page.locator("#input-example input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        assertThat(page.locator("#input-example input[type=text]")).isEnabled();
    }
}
