package pl.akademiaqa.tests.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.tests.modul_8.pages.components.TopMenuComponent;

public class HomePage extends BasePage {

    @Getter
    private TopMenuComponent topMenuComponent;

    public HomePage(Page page) {
        super(page);
        this.topMenuComponent = new TopMenuComponent(page);
    }
}
