package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsFormTest extends TestBase {

    @Test
    public void testContactUsForm() {

        assertTrue(homePage.isHomePageVisible(), "La página de inicio no se cargó correctamente.");
        homePage.accessContactUsForm();

        assertTrue(contactUsPage.isGetInTouchVisible(), "No se encontró el texto 'GET IN TOUCH'.");
        contactUsPage.sendForm();
        assertEquals("Success! Your details have been submitted successfully.", contactUsPage.getSuccessMessage());

        contactUsPage.goToHomePage();
        assertTrue(homePage.isHomePageVisible(), "No se volvió correctamente a la página de inicio.");
    }
}
