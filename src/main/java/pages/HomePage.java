package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonActionPages{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Localizadores
    By contactUsButton = By.xpath("//a[@href='/contact_us']");

    public void accessContactUsForm() {
        clickElement(contactUsButton);
    }

//    // Método para verificar que la home page se ha cargado
//    public boolean isHomePageVisible() {
//        return driver.getTitle().contains("Automation Exercise");
//    }
}
