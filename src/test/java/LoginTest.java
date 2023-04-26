import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 1.Navigate to Login page
 * 2.Click register option on login page

 * Expected result
 * 3.Verify that user is on Create account url
 */
public class LoginTest extends BaseTest {

    @Test
    public void chooseRegisterFromMenuOption() {
        ChromeDriver driver = openChromeDriver();
        try {
            System.out.println("1. Navigate to Login page");
            LoginPage loginPage = new LoginPage(driver);
            System.out.println("2. Click register option on login page");
            loginPage.clickRegisterHomePage();
            System.out.println("3. Verify that user is on Create account url");
            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals(Strings.CREATE_ACCOUNT_URL) : "Wrong url. Actual " + currentUrl;

        } finally {
            driver.quit();
        }
    }

    /**
     * 1. Navigate to Create account url
     * 2. Enter valid first name
     * 3. Enter valid last name
     * 4. Click check box button
     * 5. Enter valid email
     * 6. Enter valid password
     * 7. Enter password confirmation
     * 8. Click Show password button
     * 9. Click Login button

     * Expected result:
     * 10.Verify user registration
     */


    @Test
    public void userRegistration() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            System.out.println("1. Navigate to Create account url");
            loginPage.clickRegisterHomePage();
            System.out.println("2. Enter valid first name");
            loginPage.clickFirstName(Strings.YOUR_FIRST_NAME);
            System.out.println("3. Enter valid last name");
            loginPage.clickLastName(Strings.YOUR_LAST_NAME);
            System.out.println("4. Click check box button");
            loginPage.clickCheckBox();
            System.out.println("5. Enter valid email");
            loginPage.clickEmailAddress(Strings.YOUR_EMAIL + (int) (Math.random() * 1000));
            System.out.println("6. Enter valid password");
            loginPage.clickPassword(Strings.YOUR_PASSWORD);
            System.out.println("7. Enter password confirmation");
            loginPage.clickPasswordConfirmation(Strings.YOUR_PASSWORD);
            System.out.println("8. Click Show password button");
            loginPage.clickShowPassword();
            System.out.println("9. Click Login button");
            loginPage.clickRegisterButton();

            System.out.println("10. Verify user registration");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.CREATE_ACCOUNT_URL) : "User is on a wrong page. Expected: " +
                    "" + Strings.CREATE_ACCOUNT_URL + " Actual " + actualUrl;

        } finally {
            driver.quit();
        }
    }

    /**
     * 1. Navigate to Login Home page
     * 2. Enter valid email
     * 3. Enter valid password
     * 4. Click LOGIN button

     * Expected result:
     * 5.Verify that user is logged in
     */

    @Test
    public void loginWithValidUser() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            System.out.println("1. Navigate to Login Home page");
            loginPage.clickLOGINHomePage();
            System.out.println("2. Enter valid email");
            loginPage.clickEmailAddressLogin(Strings.YOUR_EMAIL);
            System.out.println("3. Enter valid password");
            loginPage.clickPasswordLogin(Strings.YOUR_PASSWORD);
            System.out.println("4. Click LOGIN button");
            loginPage.clickLOGIN();

            System.out.println("5.Verify that user is logged in");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.LOGIN_PAGE_URL) : "User is on a wrong page. Expected: " +
                    "" + Strings.LOGIN_PAGE_URL + " Actual " + actualUrl;
        } finally {
            driver.quit();
        }
    }

    /**
     * 1. Navigate to Login Home page
     * 2. Enter invalid email
     * 3. Enter valid password
     * 4. Click LOGIN button

     * Expected result:
     * 5.Verify that user is logged in
     */
    @Test
    public void loginWithInvalidEmailAddress() {
        ChromeDriver driver = openChromeDriver();
        try {
            System.out.println("1. Navigate to Login Home page");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickLOGINHomePage();
            System.out.println("2. Enter invalid email");
            loginPage.clickEmailAddressLogin(Strings.INVALID_EMAIL);
            System.out.println("3. Enter valid password");
            loginPage.clickPasswordLogin(Strings.YOUR_PASSWORD);
            System.out.println("4. Click LOGIN button");
            loginPage.clickLOGIN();

            System.out.println("5.Verify that user is not logged in");
            String actualUrl = driver.getCurrentUrl();
            assert !actualUrl.equals(Strings.CUSTOMER_URL) : "User is on a wrong page. Expected: " +
                    "" + Strings.LOGIN_PAGE_URL + " Actual " + actualUrl;
            String expectedSearchErrorMSG = "Email ili lozinka nisu ispravni. Pokušajte ponovo.";
            String actualErrorMessage = loginPage.getSearchErrorMessage();
            assert actualErrorMessage.equals(expectedSearchErrorMSG) : "Error. Wrong message" +
                    "Expected: " + expectedSearchErrorMSG + " .Actual " + actualErrorMessage;

        } finally {
            driver.quit();
        }
    }

    @Test (dataProvider = "failedLogin" , dataProviderClass = DataProviders.class)
    public void loginInvalidUsingDataProviders(String email, String password) {
        ChromeDriver driver = openChromeDriver();
        try {
            System.out.println("1. Navigate to Login Home page");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickLOGINHomePage();
            System.out.println("2. Enter invalid email");
            loginPage.clickEmailAddressLogin(email);
            System.out.println("3. Enter valid password");
            loginPage.clickPasswordLogin(password);
            System.out.println("4. Click LOGIN button");
            loginPage.clickLOGIN();

            System.out.println("5.Verify that user is not logged in");
            String actualUrl = driver.getCurrentUrl();
            assert !actualUrl.equals(Strings.CUSTOMER_URL) : "User is on a wrong page. Expected: " +
                    "" + Strings.LOGIN_PAGE_URL + " Actual " + actualUrl;
            String expectedSearchErrorMSG = "Email ili lozinka nisu ispravni. Pokušajte ponovo.";
            String actualErrorMessage = loginPage.getSearchErrorMessage();
            assert actualErrorMessage.equals(expectedSearchErrorMSG) : "Error. Wrong message" +
                    "Expected: " + expectedSearchErrorMSG + " .Actual " + actualErrorMessage;

        } finally {
            driver.quit();
        }
    }
}

