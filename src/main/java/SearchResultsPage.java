import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(id = "amasty-shopby-product-list")
    WebElement searchResultsTabLocator;


    @FindBy(xpath = "//div[@class='message notice']")
    WebElement searchErrorMessage;


    public SearchResultsPage(ChromeDriver driver) {
        super(driver);
        System.out.println("SearchResultsPage");

    }

    public boolean isSearchResultsPresent() {
        System.out.println("isSearchResultsPresent");
        return isElementPresent(searchResultsTabLocator);
    }

    public String getSearchErrorMessage() {
        System.out.println("getSearchErrorMessage");
        return searchErrorMessage.getText();
    }
    
}
