package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifySubscriptionInHomeTest extends TestBase {

    @Test
    public void testSubscription() {

         assertTrue(homePage.isHomePageVisible(), "La página de inicio no se cargó correctamente.");
         homePage.scrollToSubscriptionSection();

         assertTrue(homePage.isSubscriptionTextVisible(), "El texto 'SUBSCRIPTION' no es visible.");

         String email = "mariana@email.com";
         homePage.subscribeWithEmail(email);
         assertEquals("You have been successfully subscribed!", homePage.getSubscriptionSuccessMessage());
    }
}
