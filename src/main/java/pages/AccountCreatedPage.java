package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AccountCreatedPage extends CommonActionPages {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean isAccountCreatedMessageVisible() {
        return isElementVisible(accountCreatedMessage, Duration.ofSeconds(5));
    }

    public void continueShopping() {
        clickElement(continueButton);
    }
}
