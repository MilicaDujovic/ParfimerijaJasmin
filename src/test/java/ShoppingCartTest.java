import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 1. Navigate to Home page
 * 2. Choose suggested Perfume Woman
 * Expected result:
 * 3. Verify that user is on Product Home page
 */

public class ShoppingCartTest extends BaseTest {

    @Test
    public void chooseProductFromHomePage() {
        System.out.println("1. Navigate to Home page");
        ChromeDriver driver = openChromeDriver();
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            System.out.println("2. Choose suggested Perfume Woman");
            shoppingCartPage.suggestedPerfumeWoman();
            System.out.println("3. Verify that user is on Product Home page");
            assert shoppingCartPage.isButtonAddToCartPresent() : "User is on the wrong page.";

        } finally {
           driver.quit();
        }

    }
    /**
     * 1. Navigate to Home page
     * 2. Choose suggested Perfume Woman
     * 3. Add item to Shopping cart

     * Expected result:
     * 4. Verify that suggested item add to shopping cart
     */


    @Test
    public void addItemToShoppingCart() {
        System.out.println("1. Navigate to Home page");
        ChromeDriver driver = openChromeDriver();

        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            System.out.println("2. Choose suggested Perfume Woman");
            shoppingCartPage.suggestedPerfumeWoman();
            System.out.println("3. Add item to Shopping cart");
            shoppingCartPage.addToShoppingCart();

            System.out.println("4. Verify that suggested item add to shopping cart");
            String expectedMessage = "Dodali ste " + shoppingCartPage.getProductName();
            String actualMessage = shoppingCartPage.getShoppingCartMessage().substring(0, shoppingCartPage.getShoppingCartMessage().length() - 9);
            assert expectedMessage.startsWith(actualMessage) : "Error. Wrong message. " +
                    "Expected: " + expectedMessage + "  starts with " + actualMessage;

        } finally {
           driver.quit();
        }
    }

}
