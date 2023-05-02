import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class PrivacyPolicyPage extends BasePage {

    @FindBy(xpath = "//a[text()='Politika privatnosti']")
    WebElement PrivacyPolicy;

    public PrivacyPolicyPage(ChromeDriver driver) {
        super(driver);
    }

    public void clickPrivacyPolicy() {
        System.out.println("ClickPrivacyPolicy");
        PrivacyPolicy.click();
    }

}
