package pl.akademiaqa.tests.modul_8.pages.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAnAccountLocators {

    private final Page page;

    public Locator emailInput() {
        return page.locator("#email_create");
    }

    public Locator createAnAccountButton() {
        return page.locator("#SubmitCreate");
    }

    public Locator createAnAccountForm1() {
        return page.locator("#create-account_form");
    }

    public Locator createAnAccountForm2() {
        return page.locator("#account-creation_form");
    }

    public Locator genderMr() {
        return page.locator("#uniform-id_gender1");
    }

    public Locator genderMrs() {
        return page.locator("#uniform-id_gender2");
    }

    public Locator firstName() {
        return page.locator("#customer_firstname");
    }

    public Locator lastName() {
        return page.locator("#customer_lastname");
    }

    public Locator password() {
        return page.locator("#passwd");
    }

    public Locator dobDay() {
        return page.locator("#days");
    }

    public Locator dobMonth() {
        return page.locator("#months");
    }

    public Locator dobYear() {
        return page.locator("#years");
    }

    public Locator registerButton() {
        return page.locator("#submitAccount");
    }
}
