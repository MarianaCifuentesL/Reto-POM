package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductsPage extends CommonActionPages {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By allProductsHeader = By.xpath("//h2[contains(text(), 'All Products')]");
    By searchedProductsHeader = By.xpath("//h2[contains(text(), 'Searched Products')]");
    By productList = By.xpath("//div[@class='features_items']/div");

    public void searchProduct() {
        String product = "Dress";
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
}
