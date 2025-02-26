package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

public class ContactUsFormPage extends CommonActionPages {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    By nameInput = By.xpath("//input[@name='name']");
    By emailInput = By.xpath("//input[@name='email']");
    By subjectlInput = By.xpath("//input[@name='subject']");
    By messageInput = By.id("message");
    By filelInput = By.xpath("//input[@name='upload_file']");
    By submitButton = By.xpath("//input[@name='submit']");
    By successMessage = By.xpath("//div[@class='status alert alert-success']");

    public void sendForm() {

        String name = "Mariana";
        String email = "mariana@email.com";
        String subject = "Petición";
        String message = "¿Podrían cambiar el color de la página?";
        File uploadFile = new File("src/main/resources/Mapa Mental.png");

        writeText(nameInput, name);
        writeText(emailInput, email);
        writeText(subjectlInput, subject);
        writeText(messageInput, message);
        writeText(filelInput, uploadFile.getAbsolutePath());
        clickElement(submitButton);

        Alert alert = waitTimeInSeconds(Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        alert.accept();
        waitElementVisible(successMessage, Duration.ofSeconds(5));
    }

    public String getSuccessMessage() {
        return getElementText(successMessage);
    }
}
