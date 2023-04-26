import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/**
 * Search for valid brand
 * 1. Navigate to Home page
 * 2. Enter valid brand name into search field
 * 3. click search and submit button

 * Expected result:
 * 4. Verify that the search results are present
 */
public class SearchResultsTest extends BaseTest {

    @Test
    public void searchBrandTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            System.out.println("1. Navigate to Home page");
            HomePage homePage = new HomePage(driver);
            sleep(2000);
            System.out.println("2. Enter valid brand name into search field");
            homePage.enterTextAndSearchField(Strings.BRAND_NAME);
            System.out.println("3. click search and submit button");
            sleep(2000);
            homePage.clickSearchButton();

            SearchResultsPage searchResultPage = new SearchResultsPage(driver);
            System.out.println("4. Verify that the search results are present");
            assert searchResultPage.isSearchResultsPresent() : "There are NO search results";
        } finally {
            driver.quit();
        }
    }

    /**
     * Search for invalid brand
     * 1. Navigate to Home page
     * 2. Enter invalid brand name into search field
     * 3. Click search and submit button

     * Expected result:
     * 4. Verify that search results are not present
     */
    @Test
    public void searchInvalidBrandTest() {

        ChromeDriver driver = openChromeDriver();

        String expectedSearchErrorMSG = Strings.SEARCH_ERROR_MESSAGE;
        try {
            System.out.println("1. Navigate to Home page");
            HomePage homePage = new HomePage(driver);
            sleep(1000);
            System.out.println("2. Enter invalid brand name into search field");
            homePage.enterTextAndSearchField(Strings.INVALID_BRAND);
            SearchResultsPage searchResultPage = new SearchResultsPage(driver);
            sleep(2000);
            System.out.println("3. Click search and submit button");
            homePage.clickSearchButton();

            System.out.println("4. Verify that search results are not present");
            assert !searchResultPage.isSearchResultsPresent() : "There should be no results, but there ARE";
            String actualErrorMessage = searchResultPage.getSearchErrorMessage();
            assert actualErrorMessage.equals(expectedSearchErrorMSG) : "Error. Wrong message" +
                    "Expected: " + expectedSearchErrorMSG + " .Actual " + actualErrorMessage;

        } finally {
                  driver.quit();
        }
    }

}


