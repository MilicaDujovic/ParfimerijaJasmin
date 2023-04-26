import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='headerNavigation']")
    WebElement mainMenuItemsLocator;

    @FindBy(xpath = "//li[@class='level0 nav-1 category-item first level-top parent']//span[text()='ŠMINKA']")
    WebElement sminkaMenuOption;

    @FindBy(xpath = "//li[@class='level1 nav-1-3 category-item parent']")
    WebElement ociMenuOption;

    @FindBy(xpath = "//a[@data-id='141']//span")
    WebElement senkeMenuOption;

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.HOME_PAGE_URL);
        System.out.println("Home Page");

    }


    public void chooseSenkeFromMenuOption() {
        hoverOverElement(sminkaMenuOption);
        hoverOverElement(ociMenuOption);
        hoverOverElement(senkeMenuOption);
        senkeMenuOption.click();


    }

    public void clickOnMainMenuLink(String linkText) {
        System.out.println("clickOnMainMenuLink ( " + linkText + " )");
        List<WebElement> list = mainMenuItemsLocator.findElements(By.xpath("//a[@data-id='543']"));
        for (WebElement item : list) {
            String itemText = item.getText();
            if (itemText.equals(linkText)) {
                System.out.println("Clicking on " + linkText);
                item.click();
                break;
            }
        }
    }
}
