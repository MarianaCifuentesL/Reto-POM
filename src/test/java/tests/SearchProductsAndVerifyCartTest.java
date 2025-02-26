package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProductsAndVerifyCartTest extends TestBase {

    @Test
    public void testSearchProductsAndVerifyCartAfterLogin() {

        // 1️⃣ Navegar a página de productos desde Home
        homePage.accessProductsPage();

        // 2️⃣ Buscar productos
        productsPage.searchProduct("Saree");

        // 3️⃣ Verificar que se muestran productos buscados
        assertTrue(productsPage.isSearchResultVisible(), "No se muestran los productos buscados.");
//        assertTrue(productsPage.areProductsDisplayed(), "No se encontraron productos.");

        // 4️⃣ Agregar todos los productos encontrados al carrito
        productsPage.addAllSearchedProductsToCart();

        // 5️⃣ Ir al carrito y verificar productos
        homePage.accessCartPage();
        assertTrue(cartPage.areProductsInCart(), "Los productos no están en el carrito.");

        // 6️⃣ Ir a Login desde Carrito
        cartPage.accessLoginPage();

        // 7️⃣ Registrar nuevo usuario
        String name = "prueba1";
        String email = name + "@email.com";
        loginPage.signUpUser(name, email);

        // 8️⃣ Confirmar registro y volver al Home
        signupPage.signUpUser();

        assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "No se creó la cuenta correctamente.");
        accountCreatedPage.continueShopping();

        // 9️⃣ Volver a carrito y verificar productos después del login
        homePage.accessCartPage();
        assertTrue(cartPage.areProductsInCart(), "Los productos desaparecieron después del login.");

        cartPage.deleteAccount();
        deleteAccountPage.isDeleteAccountMessageVisible();
        deleteAccountPage.continueAction();
        assertTrue(homePage.isHomePageVisible(), "La página de inicio no se cargó correctamente.");


    }
}
