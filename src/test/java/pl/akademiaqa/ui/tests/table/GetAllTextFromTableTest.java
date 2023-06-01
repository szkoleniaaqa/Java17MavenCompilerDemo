package pl.akademiaqa.ui.tests.table;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.ui.pages.HomePage;
import pl.akademiaqa.common.BaseUiTest;

import java.util.List;
import java.util.stream.Collectors;

class GetAllTextFromTableTest extends BaseUiTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        System.out.println("START before each from test");
        homePage = new HomePage(page);
        System.out.println("END before each from test");
    }

    @Test
    void should_return_all_text_from_the_table() {
        homePage.clickSortableDataTable();
        List<String> strings = page.locator("table#table1 td").allInnerTexts();
        strings.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    void should_return_first_text_from_multiple_locators() {
        page.locator("text=Table").click();
        String h4 = page.locator("h4").first().innerText();
//        String h4 = page.locator("h4").last().innerText();
//        String h4 = page.locator("h4").nth(1).innerText();
        System.out.println(h4);
    }

    @Test
    void should_return_text_from_single_locator() {
        page.locator("text=Table").click();
        String h3text = page.locator("h3").innerText();
        System.out.println(h3text);
    }

    @Test
    void should_return_list_of_users_from_the_table() {
        page.locator("text=Table").click();
        List<Locator> trs = page.locator("#table1 tbody tr").all();

        List<TableUser> users = trs.stream()
                .map(tr -> {
                    List<Locator> tds = tr.getByRole(AriaRole.CELL).all();
                    String firstName = tds.get(1).innerText();
                    String lastName = tds.get(0).innerText();
                    String email = tds.get(2).innerText();
                    String due = tds.get(3).innerText();
                    String website = tds.get(4).innerText();
                    Locator action = tds.get(5);
                    return new TableUser(firstName, lastName, email, due, website, action);
                }).collect(Collectors.toList());

        TableUser frank = users.stream()
                .filter(user -> user.getFirstName().startsWith("Frank"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        frank.getAction().getByText("edit").click();
    }
}
