package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonActionPages {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailSignupInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    public void signUpUser(String name, String email) {
        writeText(nameInput, name);
        writeText(emailSignupInput, email);
        clickElement(signupButton);
    }
}
