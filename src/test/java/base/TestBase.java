package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductsPage;

public class TestBase {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ContactUsPage contactUsPage;
    protected ProductsPage productsPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        driver = homePage.chromeDriverConection();
        homePage.visitPage("https://automationexercise.com/");
        contactUsPage = new ContactUsPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }
}
