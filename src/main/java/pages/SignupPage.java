package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends CommonActionPages {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    By passwordInput = By.id("password");
    By firstnameInput = By.id("first_name");
    By lastnameInput = By.id("last_name");
    By addressInput = By.id("address1");
    By countryInput = By.id("country");
    By stateInput = By.id("state");
    By cityInput = By.id("city");
    By zipcodeInput = By.id("zipcode");
    By mobileNumberInput = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");


    public void signUpUser() {

        String password = "1234";
        String firstname = "Mariana";
        String lastname = "Cifuentes";
        String address = "1234 Test St";
        String country = "Canada";
        String state = "Ontario";
        String city = "Toronto";
        String zipcode = "M4B 1B3";
        String mobileNumber = "1234567890";

        writeText(passwordInput, password);
        writeText(firstnameInput, firstname);
        writeText(lastnameInput, lastname);
        writeText(addressInput, address);
        selectDropdownByVisibleText(countryInput, country);
        writeText(stateInput, state);
        writeText(cityInput, city);
        writeText(zipcodeInput, zipcode);
        writeText(mobileNumberInput, mobileNumber);

        clickElement(createAccountButton);

    }
}
