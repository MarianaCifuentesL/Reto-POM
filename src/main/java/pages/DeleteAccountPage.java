package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class DeleteAccountPage extends CommonActionPages {

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement deleteAccountMessage;

    public void continueAction() {
        clickElement(continueButton);
    }

    public void isDeleteAccountMessageVisible() {
        isElementVisible(deleteAccountMessage, Duration.ofSeconds(5));
    }
}
