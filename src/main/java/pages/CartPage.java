package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends CommonActionPages {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']//tr")
    private List<WebElement> cartProducts;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signupLoginButton;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountButton;

    public boolean areProductsInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(cartProducts));
        return !cartProducts.isEmpty();
    }

    public void accessLoginPage() {
        clickElement(signupLoginButton);
    }

    public void deleteAccount() {
        clickElement(deleteAccountButton);
    }
}
