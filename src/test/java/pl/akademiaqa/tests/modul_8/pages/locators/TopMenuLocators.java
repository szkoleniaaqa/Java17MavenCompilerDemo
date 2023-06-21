package pl.akademiaqa.tests.modul_8.pages.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TopMenuLocators {

    private final Page page;

    public Locator contactUsLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
    }

    public Locator signInLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in"));
    }
}
