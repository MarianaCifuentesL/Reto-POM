package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends CommonActionPages{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By contactUsButton = By.xpath("//a[@href='/contact_us']");
    By homeBanner = By.id("slider-carousel");

    public void accessContactUsForm() {
        clickElement(contactUsButton);
    }

    public boolean isHomePageVisible() {
        return isElementVisible(homeBanner, Duration.ofSeconds(5));
    }

}
