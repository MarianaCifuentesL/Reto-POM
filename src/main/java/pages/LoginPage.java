package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonActionPages{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By nameInput = By.xpath("//input[@name='name']");
    By emailSignupInput = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");

    public void signUpUser(String name, String email) {
        writeText(nameInput, name);
        writeText(emailSignupInput, email);
        clickElement(signupButton);

    }
}
