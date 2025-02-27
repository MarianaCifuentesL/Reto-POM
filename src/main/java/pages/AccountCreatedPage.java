package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AccountCreatedPage extends CommonActionPages {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public boolean isAccountCreatedMessageVisible() {
        return isElementVisible(accountCreatedMessage, Duration.ofSeconds(5));
    }

    public void continueShopping() {
        clickElement(continueButton);
    }
}
