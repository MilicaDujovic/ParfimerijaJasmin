import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 1. Navigate to Home page
 * 2.Choose senke from Menu option

 * Expected result
 * 3.  Verify that user is on SENKE url
 */

public class HomeTest extends BaseTest {

    @Test
    public void chooseSenkeFromMainMenuOption() {
        ChromeDriver driver = openChromeDriver();
        try {
            System.out.println("1. Navigate to Home page");
            HomePage homePage = new HomePage(driver);
            System.out.println("2.Choose senke from Menu option");
            homePage.chooseSenkeFromMenuOption();
            String currentUrl = driver.getCurrentUrl();
            System.out.println("3. Verify that user is on SENKE url");
            assert currentUrl.equals(Strings.SENKE_URL) : "Wrong url. Actual " + currentUrl;

        } finally {
           driver.quit();
        }

    }

    /**
     * 1. Navigate to Home page
     * 2.Choose Muski parfemi from Menu option

     * Expected result
     * 3.  Verify that user is on Muski parfemi url
     */
    @Test
    public void mainMenuNavigationTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            System.out.println("1. Navigate to Home page");
            HomePage homePage = new HomePage(driver);
            System.out.println("2.Choose Muski parfemi from Menu option");
            homePage.clickOnMainMenuLink(Strings.MUSKI_PARFEMI);
            System.out.println("3. Verify that user is on Muski parfemi url");
            assert isCurrentURLequalTo(driver, Strings.MUSKI_PARFEMI_URL) : "User is NOT on expected page. " +
                    "Expected: " + Strings.MUSKI_PARFEMI_URL + " . Actual: " + driver.getCurrentUrl();

        } finally {
            driver.quit();
        }
    }

}
