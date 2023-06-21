package pl.akademiaqa.tests.modul_8.pages.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.tests.modul_8.pages.locators.CreateAnAccountLocators;
import pl.akademiaqa.tests.modul_8.pages.locators.CreateAnAccountSelectors;

import static pl.akademiaqa.tests.modul_8.pages.locators.CreateAnAccountSelectors.*;

public class CreateAnAccountFormComponent {

    // Gdzie trzymać lokatory???
    // W klasie PO i inicjalizować je w konstruktorze, tak jak w dokumentacji ;(
    // Można trzymać selektory jako stringi i używać ich w metodach
    // Osobna klasa do trzymania lokatorów ;)
    // Osobna klasa z selektorami i texami

    private Page page;
    private CreateAnAccountLocators locators;

    public CreateAnAccountFormComponent(Page page) {
        this.page = page;
        this.locators = new CreateAnAccountLocators(page);
    }

    // LOKATORY
    public CreateAnAccountLocators getLocators() {
        return locators;
    }

    // AKCJE
    public void enterEmail(String email) {
        page.locator(EMAIL_INPUT_SELECTOR).fill(email);
        locators.emailInput().fill(email);
    }

    public Locator getEmailInput() {
        return page.locator(EMAIL_INPUT_SELECTOR);
    }

    public void clickCreateAnAccountButton() {
        locators.createAnAccountButton().click();
    }

    public CreateAnAccountFormComponent checkGenderMr() {
        locators.genderMr().check();
        return this;
    }

    public CreateAnAccountFormComponent checkGenderMrs() {
        locators.genderMrs().check();
        return this;

    }

    public CreateAnAccountFormComponent enterFirstName(String firstName) {
        locators.firstName().fill(firstName);
        return this;
    }

    public CreateAnAccountFormComponent enterLastName(String lastName) {
        locators.lastName().fill(lastName);
        return this;
    }

    public CreateAnAccountFormComponent enterPassword(String password) {
        locators.password().fill(password);
        return this;
    }

    public CreateAnAccountFormComponent setDateOfBirth(String day, String month, String year) {
        locators.dobDay().selectOption(day);
        locators.dobMonth().selectOption(month);
        locators.dobYear().selectOption(year);
        return this;
    }

    public void clickRegisterButton() {
        locators.registerButton().click();
    }
}
