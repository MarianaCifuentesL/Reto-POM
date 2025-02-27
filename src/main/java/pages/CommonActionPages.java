package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CommonActionPages {

    protected WebDriver driver;
    private static final String START_MAXIMIZED = "--start-maximized";
    private static final Logger logger = LoggerFactory.getLogger(CommonActionPages.class);

    public CommonActionPages (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConection() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(START_MAXIMIZED);
        driver = new ChromeDriver(options);
        return driver;
    }

    public void visitPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriverWait waitTimeInSeconds(Duration duration) {
        return new WebDriverWait(driver, duration);
    }

    public void scrollIntoWebElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public boolean isElementVisible(WebElement element, Duration timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            logger.warn("Error al verificar visibilidad");

            return false;
        }
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitElementVisible(WebElement element, Duration timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void selectDropdownByVisibleText(WebElement element, String visibleText) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }
}