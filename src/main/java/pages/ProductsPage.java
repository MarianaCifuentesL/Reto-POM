package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends CommonActionPages {

    private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//h2[contains(text(), 'All Products')]")
    private WebElement allProductsHeader;

    @FindBy(xpath = "//h2[contains(text(), 'Searched Products')]")
    private WebElement searchedProductsHeader;

    @FindBy(xpath = "//div[@class='features_items']/div")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    private WebElement continueShoppingButton;

    public void searchProduct(String product) {
        writeText(searchInput, product);
        clickElement(searchButton);
    }

    public boolean isSearchResultVisible() {
        return isElementVisible(searchedProductsHeader, Duration.ofSeconds(5));
    }

    public boolean areProductsDisplayed() {
        return !productList.isEmpty();
    }

    public boolean isProductsPageVisible() {
        return isElementVisible(allProductsHeader, Duration.ofSeconds(5));
    }

    public void addAllSearchedProductsToCart() {
        for (WebElement button : addToCartButtons) {
            scrollIntoWebElement(button);
            button.click();

            try {
                WebDriverWait wait = waitTimeInSeconds(Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
            } catch (TimeoutException e) {
                logger.warn("No se encontró el botón de continuar comprando, se sigue con el siguiente producto.");
            }
        }
    }
}
