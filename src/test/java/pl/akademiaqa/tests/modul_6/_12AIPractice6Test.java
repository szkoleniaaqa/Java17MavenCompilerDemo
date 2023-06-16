package pl.akademiaqa.tests.modul_6;

import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class _12AIPractice6Test extends BaseTest {

    // Chat GPT-4

    @Test
    public void testPriceAbove15() {
        page.navigate("http://www.automationpractice.pl/index.php?id_category=8&controller=category");

        // Get all the product price elements
        var priceElements = page.querySelectorAll(".product_list .ajax_block_product .right-block .content_price .price");

        for (var priceElement : priceElements) {
            String priceText = priceElement.innerText();
            System.out.println(priceText);

            // Assuming price is in format "$00.00", we remove the dollar sign and parse it as a double
            double price = Double.parseDouble(priceText.substring(1));
            System.out.println(price);
            assertTrue(price > 15, "Product price should be above $15");
        }
    }
}
