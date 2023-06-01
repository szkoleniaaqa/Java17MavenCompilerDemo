package pl.akademiaqa.ui.tests.iframe;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.common.BaseUiTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NestedFramesTest extends BaseUiTest {

    @Test @Disabled
    void should_get_text_from_nested_frames(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Frames").setExact(true)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Nested Frames")).click();
        // Jeżeli jest podany frame name to używamy .frame(frameName)
        assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");
    }
}
