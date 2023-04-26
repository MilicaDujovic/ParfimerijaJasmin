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

    @FindBy(xpath = "//section[@data-amsearch-js='results']")
    WebElement searchSuggestionDropdown;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public BasePage enterTextAndSearchField(String text) {
        System.out.println("enterTextAndSearchField");
        searchField.click();
        searchField.sendKeys(text);
        return this;

    }

    public void clickSearchButton() {
        System.out.println("clickSearchButton");
        searchButton.click();
    }


    public boolean isElementPresent(WebElement element) {
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            System.out.println("Element is not present on page");
            return false;
        }
    }


    public SearchResultsPage SearchButton() {
        assert searchButton.isDisplayed() : "Search icon is NOT present";
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public void selectDropdown(String text) {
        waitForElement(searchSuggestionDropdown);
        List<WebElement> listSuggestions = searchSuggestionDropdown.findElements(By.xpath("//a[@class='amsearch-link item-name']"));
        for (WebElement suggestion : listSuggestions) {
            String suggestionText = suggestion.getText();
            if (suggestionText.equals(text)) {
                hoverOverElement(suggestion);
                suggestion.click();
                break;
            }
        }

    }


    public void hoverOverElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].mouseOver()", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
