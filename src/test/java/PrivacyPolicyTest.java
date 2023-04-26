import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 1. Click footer item - Privacy Policy

 * Expected result:
 * 2. Verify that user is on Privacy Policy page
 */
public class PrivacyPolicyTest extends BaseTest {

    @Test
    public void openPrivacyPolicyPage() {

        ChromeDriver driver = openChromeDriver();
        try {
            PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driver);
            System.out.println("1. Click footer item - Privacy Policy");
            privacyPolicyPage.clickPrivacyPolicy();
            String actualUrl = driver.getCurrentUrl();
            System.out.println("2. Verify that user is on Privacy Policy page");
            assert actualUrl.equals(Strings.PRIVACY_POLICY_URL) : "User is on a wrong page. Expected: " +
                    "" + Strings.PRIVACY_POLICY_URL + " Actual " + actualUrl;

        } finally {
            driver.quit();
        }
    }

}
