package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProductsAndVerifyCartTest extends TestBase {

    @Test
    public void testSearchProductsAndVerifyCartAfterLogin() {

        homePage.accessProductsPage();
        productsPage.searchProduct("Saree");
        assertTrue(productsPage.isSearchResultVisible(), "No se muestran los productos buscados.");

        productsPage.addAllSearchedProductsToCart();
        homePage.accessCartPage();
        assertTrue(cartPage.areProductsInCart(), "Los productos no están en el carrito.");

        cartPage.accessLoginPage();

        String name = "prueba1";
        String email = name + "@email.com";
        loginPage.signUpUser(name, email);

        String password = "1234";
        String firstname = "Mariana";
        String lastname = "Cifuentes";
        String address = "1234 Test St";
        String country = "Canada";
        String state = "Ontario";
        String city = "Toronto";
        String zipcode = "M4B 1B3";
        String mobileNumber = "1234567890";

        signupPage.signUpUser(password, firstname, lastname, address, country, state, city, zipcode, mobileNumber);

        assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "No se creó la cuenta correctamente.");
        accountCreatedPage.continueShopping();

        homePage.accessCartPage();
        assertTrue(cartPage.areProductsInCart(), "Los productos desaparecieron después del login.");

        cartPage.deleteAccount();
        deleteAccountPage.isDeleteAccountMessageVisible();
        deleteAccountPage.continueAction();
        assertTrue(homePage.isHomePageVisible(), "La página de inicio no se cargó correctamente.");
    }
}
