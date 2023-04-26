import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class PrivacyPolicyPage extends BasePage {

    public PrivacyPolicyPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Politika privatnosti']")
    WebElement PrivatyPolicy;


    public void clickPrivacyPolicy() {
        System.out.println("ClickPrivacyPolicy");
        PrivatyPolicy.click();
    }

}
