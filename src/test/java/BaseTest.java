import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    public ChromeDriver openChromeDriver() {
        logger.info("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Strings.HOME_PAGE_URL);

        return driver;
    }

    public boolean isCurrentURLequalTo(ChromeDriver driver, String expectedUrl) {
        System.out.println("isCurrentURLequalTo ( " + expectedUrl + " )");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("User is on " + currentUrl);
        boolean isEqual = currentUrl.equals(expectedUrl);
        return isEqual;
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
