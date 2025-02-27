package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.*;

public class TestBase {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ContactUsPage contactUsPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected AccountCreatedPage accountCreatedPage;
    protected DeleteAccountPage deleteAccountPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        driver = homePage.chromeDriverConection();
        homePage.visitPage("https://automationexercise.com/");
        contactUsPage = new ContactUsPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
