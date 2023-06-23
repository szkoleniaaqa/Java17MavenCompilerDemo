package pl.akademiaqa.tests.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.tests.modul_8.pages.sections.TopMenuSection;

public class BasePage {

    protected Page page;
    @Getter
    protected TopMenuSection topMenuSection;

    public BasePage(Page page) {
        this.page = page;
        this.topMenuSection = new TopMenuSection(page);
    }
}
