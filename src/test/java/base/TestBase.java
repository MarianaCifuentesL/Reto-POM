package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.ContactUsFormPage;
import pages.HomePage;

public class TestBase {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        driver = homePage.chromeDriverConection();
        homePage.visitPage("https://automationexercise.com/");
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }
}
