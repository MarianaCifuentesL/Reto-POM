package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends CommonActionPages {

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "first_name")
    private WebElement firstnameInput;

    @FindBy(id = "last_name")
    private WebElement lastnameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public void signUpUser(String password, String firstname, String lastname, String address, String country, String state, String city, String zipcode, String mobileNumber) {

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
