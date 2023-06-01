package pl.akademiaqa.ui.tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.constans.AppConstans;
import pl.akademiaqa.common.BaseUiTest;

public class FirstTest extends BaseUiTest {

    @Test
    void sample1Test() {
        System.out.println("First test 1 " + page.title());
        PlaywrightAssertions.assertThat(page).hasTitle(AppConstans.HOME_PAGE_TITLE);
    }

    @Test
    void sample2Test() {
        System.out.println("First test 2 " + page.title());
    }

    @Test
    void sample3Test() {
        System.out.println("First test 3 " + page.title());
    }

}
