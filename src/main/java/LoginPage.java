import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@id='iddDUmFVJN']")
    WebElement register;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;

    @FindBy(xpath = " //input[@name='assistance_allowed_checkbox']")
    WebElement checkBox;

    @FindBy(xpath = "//input[@id='email_address']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@name='login[username]']")
    WebElement emailAddressLogin;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='login[password]']")
    WebElement passwordLogin;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    WebElement passwordConfirmation;

    @FindBy(xpath = "//input[@id='show-password']")
    WebElement showPassword;

    @FindBy(xpath = "//button[@class='action submit primary']")
    WebElement buttonRegister;

    @FindBy(xpath = "//li[@data-label='ili']")
    WebElement buttonLOGIN;

    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement LOGIN;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement errorMessage;

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    public void clickRegisterHomePage() {
        hoverOverElement(hoverOverLogin);
  //      waitForElement(register);
        hoverOverElement(register);
//        waitForElement(register);
        register.click();
    }

    public void clickLOGINHomePage() {
        hoverOverElement(hoverOverLogin);
        hoverOverElement(buttonLOGIN);
        buttonLOGIN.click();
    }


    public void clickFirstName(String text) {
        firstName.click();
        firstName.sendKeys(text);
    }

    public void clickLastName(String text) {
        lastName.click();
        lastName.sendKeys(text);
    }

    public void clickCheckBox() {
        checkBox.click();
    }

    public void clickEmailAddress(String text) {
        emailAddress.click();
        emailAddress.sendKeys(text);
    }

    public void clickEmailAddressLogin(String text) {
        emailAddressLogin.click();
        emailAddressLogin.sendKeys(text);
    }

    public void clickPassword(String text) {
        password.click();
        password.sendKeys(text);
    }

    public void clickPasswordLogin(String text) {
        passwordLogin.click();
        passwordLogin.sendKeys(text);
    }

    public void clickPasswordConfirmation(String text) {
        passwordConfirmation.click();
        passwordConfirmation.sendKeys(text);
    }

    public void clickShowPassword() {

        showPassword.click();
    }

    public void clickRegisterButton() {

        buttonRegister.click();
    }

    public void clickLOGIN() {
        waitForElement(LOGIN);
        LOGIN.click();
    }

    public String getSearchErrorMessage() {
        System.out.println("getSearchErrorMessage");
        waitForElement(errorMessage);
        return errorMessage.getText();
    }

}
