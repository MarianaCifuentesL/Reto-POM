package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUsFormTest extends TestBase {

    @Test
    public void testContactUsForm() {
        homePage.accessContactUsForm();
        contactUsFormPage.sendForm();
        assertEquals("Success! Your details have been submitted successfully.", contactUsFormPage.getSuccessMessage());
    }

}
