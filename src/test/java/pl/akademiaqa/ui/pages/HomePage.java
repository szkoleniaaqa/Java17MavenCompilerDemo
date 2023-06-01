package pl.akademiaqa.ui.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private String sortableDataTable = "text=Sortable Data Tables";

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickSortableDataTable() {
        page.locator(sortableDataTable).click();
    }
}
