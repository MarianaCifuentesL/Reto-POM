package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends CommonActionPages{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By contactUsButton = By.xpath("//a[@href='/contact_us']");
    By productsButton = By.xpath("//a[@href='/products']");
    By homeBanner = By.id("slider-carousel");
    By subscriptionText = By.xpath("//h2[contains(text(), 'Subscription')]");
    By emailInput = By.id("susbscribe_email");
    By subscribeButton = By.id("subscribe");
    By successMessage = By.xpath("//div[@class='alert-success alert']");
    By loginButton = By.xpath("//a[@href='/login']");
    By cartButton = By.xpath("//a[@href='/view_cart']");
    By deleteAccountButton = By.xpath("//a[@href='/delete_account']");

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
        scrollToElement(subscriptionText);
    }

    public boolean isSubscriptionTextVisible() {
        return isElementVisible(subscriptionText, Duration.ofSeconds(5));
    }

    public void subscribeWithEmail() {
        String email = "mariana@email.com";
        writeText(emailInput, email);
        clickElement(subscribeButton);
    }

    public String getSubscriptionSuccessMessage() {
        return getElementText(successMessage);
    }

    public void accessCartPage() {
        clickElement(cartButton);
    }

    public void accessLoginPage() {
        clickElement(loginButton);
    }

    public void deleteAccount() {
        clickElement(deleteAccountButton);
    }

}
