package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductsPage extends CommonActionPages {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By allProductsHeader = By.xpath("//h2[contains(text(), 'All Products')]");
    By searchedProductsHeader = By.xpath("//h2[contains(text(), 'Searched Products')]");
    By productList = By.xpath("//div[@class='features_items']/div");
    By addToCartButtons = By.xpath("//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']");
    By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

    public void searchProduct(String product) {
        writeText(searchInput, product);
        clickElement(searchButton);
    }

    public boolean isSearchResultVisible() {
        return isElementVisible(searchedProductsHeader, Duration.ofSeconds(5));
    }

    public boolean areProductsDisplayed() {
        return getElementCount(productList) > 0;
    }

    public boolean isProductsPageVisible() {
        return isElementVisible(allProductsHeader, Duration.ofSeconds(5));
    }

    public void addAllSearchedProductsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);

        for (WebElement button : buttons) {
            scrollIntoWebElement(button);
            button.click();

            try {
                WebDriverWait wait = waitTimeInSeconds(Duration.ofSeconds(5));
                WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
                popupButton.click(); // Cierra el popup si aparece
            } catch (TimeoutException e) {
                System.out.println("No se encontró el botón de continuar comprando, se sigue con el siguiente producto.");
            }
        }
    }
}
