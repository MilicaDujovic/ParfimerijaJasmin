import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    ChromeDriver driver;
    @FindBy(xpath = ".//div[@class='header-holder']")
    WebElement hoverOverLogin;

    @FindBy(xpath = "//input[@class='amsearch-input']")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='amsearch-button -loupe -clear -icon']")
    WebElement searchButton;


    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void enterTextAndSearchField(String text) {
        System.out.println("enterTextAndSearchField");
        searchField.click();
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        System.out.println("clickSearchButton");
        searchButton.click();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean isPresent = element.isDisplayed();
            return isPresent;
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            System.out.println("Element is not present on page");
            return false;
        }
    }


    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
