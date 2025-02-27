package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsFormTest extends TestBase {

    @Test
    public void testContactUsForm() {

        assertTrue(homePage.isHomePageVisible(), "La página de inicio no se cargó correctamente.");
        homePage.accessContactUsForm();

        assertTrue(contactUsPage.isGetInTouchVisible(), "No se encontró el texto 'GET IN TOUCH'.");

        String name = "Mariana";
        String email = "mariana@email.com";
        String subject = "Petición";
        String message = "¿Podrían cambiar el color de la página?";
        File uploadFile = new File("src/main/resources/Mapa Mental.png");

        contactUsPage.sendForm(name, email, subject, message, uploadFile);
        assertEquals("Success! Your details have been submitted successfully.", contactUsPage.getSuccessMessage());

        contactUsPage.goToHomePage();
        assertTrue(homePage.isHomePageVisible(), "No se volvió correctamente a la página de inicio.");
    }
}
