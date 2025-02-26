package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends CommonActionPages {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By cartButton = By.xpath("//a[@href='/view_cart']");
    By cartProducts = By.xpath("//table[@id='cart_info_table']//tr");
    By signupLoginButton = By.xpath("//a[@href='/login']");
    By deleteAccountButton = By.xpath("//a[@href='/delete_account']");

    public void openCart() {
        clickElement(cartButton);
    }

    public boolean areProductsInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='cart_info_table']//tr")));

        int productosEnCarrito = getElementCount(cartProducts);
        System.out.println("Productos en el carrito después del login: " + productosEnCarrito);

        return productosEnCarrito > 0;
    }


    public void accessLoginPage() {
        clickElement(signupLoginButton);
    }

    public void deleteAccount() {
        clickElement(deleteAccountButton);
    }
}
