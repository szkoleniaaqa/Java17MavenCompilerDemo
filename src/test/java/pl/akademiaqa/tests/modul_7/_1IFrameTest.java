package pl.akademiaqa.tests.modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _1IFrameTest extends BaseTest {

    @Test
    void should_enter_the_text_into_the_iframe(){
        page.navigate("http://the-internet.herokuapp.com/iframe");
        // Jeżeli nie ma podanego frame name to używamy .frameLocator(id lub css)
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("Hello World!");
    }

    @Test
    void should_get_text_from_nested_frames(){
        page.navigate("http://the-internet.herokuapp.com/nested_frames");
        // Jeżeli jest podany frame name to używamy .frame(frameName)
        assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");
    }
}
