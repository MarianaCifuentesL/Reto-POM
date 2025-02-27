package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class HomePage extends CommonActionPages {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;

    @FindBy(id = "slider-carousel")
    private WebElement homeBanner;

    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    private WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    private WebElement emailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cartButton;

    public void accessProductsPage() {
        clickElement(productsButton);
    }

    public void accessContactUsForm() {
        clickElement(contactUsButton);
    }

    public boolean isHomePageVisible() {
        return isElementVisible(homeBanner, Duration.ofSeconds(5));
    }

    public void scrollToSubscriptionSection() {
        scrollIntoWebElement(subscriptionText);
    }

    public boolean isSubscriptionTextVisible() {
        return isElementVisible(subscriptionText, Duration.ofSeconds(5));
    }

    public void subscribeWithEmail(String email) {
        writeText(emailInput, email);
        clickElement(subscribeButton);
    }

    public String getSubscriptionSuccessMessage() {
        return getElementText(successMessage);
    }

    public void accessCartPage() {
        clickElement(cartButton);
    }
}
