import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    String productName;
    @FindBy(xpath = "//div[@class='block widget block-products-list grid']")
    WebElement allProducts;

    @FindBy(xpath = "//div[@class='swatch-attribute imp_volume']")
    WebElement selectProduceItem;

    @FindBy(id = "product-addtocart-button")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement shoppingCartMessage;


    public ShoppingCartPage(ChromeDriver driver) {
        super(driver);
    }

    public void suggestedPerfumeWoman() {
        waitForElement(allProducts);
        List<WebElement> allProductsList = allProducts.findElements(By.xpath("//div[@class='product-item-details']"));
        WebElement firstProduct = allProductsList.get(0);
        waitForElement(firstProduct);
        firstProduct.click();
    }

    public void addToShoppingCart() {
        waitForElement(selectProduceItem);
        List<WebElement> selectProductItemList = selectProduceItem.findElements(By.xpath("//div[@class='swatch-option text']"));
        WebElement firstSelect = selectProductItemList.get(0);
        waitForElement(firstSelect);

        productName = firstSelect.getText();

        firstSelect.click();
        buttonAddToCart.click();
    }

    public boolean isButtonAddToCartPresent() {
        System.out.println("isButtonAddToCartPresent");
        return isElementPresent(buttonAddToCart);
    }

    public String getShoppingCartMessage() {
        System.out.println("getShoppingCartMessage");
        waitForElement(shoppingCartMessage);
        return shoppingCartMessage.getText();
    }

    public String getProductName() {
        return productName;
    }

}

