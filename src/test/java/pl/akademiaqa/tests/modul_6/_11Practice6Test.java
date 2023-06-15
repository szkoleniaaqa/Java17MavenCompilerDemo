package pl.akademiaqa.tests.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import java.util.ArrayList;
import java.util.List;


class _11Practice6Test extends BaseTest {

    @Test
    void should_verify_all_product_prices_are_above_15_usd() {
        List<ProductTable> allProducts = getAllProducts();

        List<Integer> prices = new ArrayList<>();
        allProducts.forEach(p -> prices.add(p.getPrice()));
        Assertions.assertThat(prices.stream().allMatch(p -> p > 15)).isTrue();
    }

    @Test
    void should_verify_all_product_names_contains_printed() {
        List<ProductTable> allProducts = getAllProducts();

        List<String> names = new ArrayList<>();
        allProducts.forEach(p -> names.add(p.getName()));
        Assertions.assertThat(names.stream().allMatch(n -> n.contains("Printed"))).isTrue();
    }

    private List<ProductTable> getAllProducts() {
        page.navigate("http://www.automationpractice.pl/");
        Locator topMenuBlock = page.locator("#block_top_menu");
        topMenuBlock.locator(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DRESSES"))).click();
        List<Locator> productsLocator = page.locator(".product_list .ajax_block_product").all();

        List<ProductTable> products = new ArrayList<>();

        productsLocator.forEach(p -> {
            int price = Integer.valueOf(p.locator(".right-block .content_price .price").innerText().replace("$", ""));
            String name = p.locator(".product-name").innerText();
            products.add(new ProductTable(name, price));
        });

        return products;
    }
}
