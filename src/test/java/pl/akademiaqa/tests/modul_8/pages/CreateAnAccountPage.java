package pl.akademiaqa.tests.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.tests.modul_8.pages.components.CreateAnAccountFormComponent;

public class CreateAnAccountPage extends BasePage {

    @Getter
    private CreateAnAccountFormComponent createAnAccountFormComponent;

    public CreateAnAccountPage(Page page) {
        super(page);
        this.createAnAccountFormComponent = new CreateAnAccountFormComponent(page);
    }
}
