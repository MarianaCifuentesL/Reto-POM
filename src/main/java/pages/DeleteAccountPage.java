package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DeleteAccountPage extends CommonActionPages {

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    By continueButton = By.xpath("//a[@data-qa='continue-button']");
    By deleteAccountMessage = By.xpath("//h2[@data-qa='account-deleted']");

    public void continueAction() {
        clickElement(continueButton);
    }

    public void isDeleteAccountMessageVisible() {
        isElementVisible(deleteAccountMessage, Duration.ofSeconds(5));
    }
}
