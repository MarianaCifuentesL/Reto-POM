package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

public class ContactUsPage extends CommonActionPages {

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    private WebElement getInTouchText;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement fileInput;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement homeButton;

    public boolean isGetInTouchVisible() {
        return isElementVisible(getInTouchText, Duration.ofSeconds(5));
    }

    public void sendForm(String name, String email, String subject, String message, File uploadFile) {
        writeText(nameInput, name);
        writeText(emailInput, email);
        writeText(subjectInput, subject);
        writeText(messageInput, message);
        writeText(fileInput, uploadFile.getAbsolutePath());
        clickElement(submitButton);

        Alert alert = waitTimeInSeconds(Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        alert.accept();
        waitElementVisible(successMessage, Duration.ofSeconds(5));
    }

    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    public void goToHomePage() {
        clickElement(homeButton);
    }
}
