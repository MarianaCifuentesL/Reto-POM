package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionPages {

    protected WebDriver driver;

    public CommonActionPages (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConection() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void visitPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void writeText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public WebDriverWait waitTimeInSeconds(Duration duration) {
        return new WebDriverWait(driver, duration);
    }

    public void waitElementVisible(By locator, Duration timeInSecods) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSecods);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementVisible(By locator, Duration timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    public int getElementCount(By locator) {
        return driver.findElements(locator).size();
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    public void clickAllElements(By locator) {
        for (var element : driver.findElements(locator)) {
            element.click();
        }
    }

    public String getInputValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public void selectDropdownByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(visibleText);
    }

}