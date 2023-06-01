package pl.akademiaqa.ui.tests.iframe;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

public class IFrameTest extends BaseUiTest {

    @Test @Disabled
    void should_enter_the_text_into_the_iframe(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Frames").setExact(true)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("iFrame")).click();
        // Jeżeli nie ma podanego frame name to używamy .frameLocator(id lub css)
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("Hello World!");
    }
}
