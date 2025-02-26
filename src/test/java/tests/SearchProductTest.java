package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProductTest extends TestBase {

    @Test
    public void testSearchProduct() {

        assertTrue(homePage.isHomePageVisible(), "La página de inicio no se cargó correctamente.");
        homePage.accessProductsPage();

        assertTrue(productsPage.isProductsPageVisible(), "No se cargó la página de 'All Products'.");
        productsPage.searchProduct("Dress");

        assertTrue(productsPage.isSearchResultVisible(), "No se encontró el encabezado 'Searched Products'.");
        assertTrue(productsPage.areProductsDisplayed(), "No se encontraron productos en la búsqueda.");
    }
}
