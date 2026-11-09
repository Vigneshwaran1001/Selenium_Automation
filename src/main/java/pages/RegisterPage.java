package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {
    public RegisterPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(name = "customer.address.zipCode")
    WebElement zipcode;

    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    WebElement ssn;

    @FindBy(id = "customer.username")
    WebElement username;

    @FindBy(id = "customer.password")
    WebElement password;

    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerBtn;

    @FindBy(xpath = "//h1")
    WebElement pageHeading;

    @FindBy(id = "rightPanel")
    WebElement rightPanel;

    public void enterFirstName(String name){
        sendKeys(firstName, name);
    }

    public void enterLastName(String name){
        sendKeys(lastName, name);
    }

    public void enterAddress(String value){
        sendKeys(address, value);
    }

    public void enterCity(String value){
        sendKeys(city, value);
    }

    public void enterState(String value){
        sendKeys(state, value);
    }

    public void enterZipcode(String value){
        sendKeys(zipcode, value);
    }

    public void enterPhoneNumber(String value){
        sendKeys(phoneNumber, value);
    }

    public void enterSSN(String value){
        sendKeys(ssn, value);
    }

    public void enterUserName(String value){
        sendKeys(username, value);
    }

    public void enterPassword(String value){
        sendKeys(password, value);
    }

    public void enterConfirmPassword(String value){
        sendKeys(confirmPassword, value);
    }

    public void clickRegisterBtn(){
        click(registerBtn);
    }

    public String getPageHeading(){
        return getText(pageHeading);
    }

    public String getSuccessMessage(){
        return getText(rightPanel);
    }

}
