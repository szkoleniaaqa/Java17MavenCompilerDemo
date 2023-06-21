package pl.akademiaqa.tests.modul_8.pages;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }
}
