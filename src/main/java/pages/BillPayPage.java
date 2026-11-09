package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage extends BaseClass {

    public BillPayPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(name = "payee.name")
    WebElement payeeName;

    @FindBy(name = "payee.address.street")
    WebElement payeeStreet;

    @FindBy(name = "payee.address.city")
    WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    WebElement payeeZipcode;

    @FindBy(name = "payee.phoneNumber")
    WebElement payeePhoneNumber;

    @FindBy(name = "payee.accountNumber")
    WebElement payeeAccountNumber;

    @FindBy(name = "verifyAccount")
    WebElement payeeVerifyAccount;

    @FindBy(name = "amount")
    WebElement amount;

    @FindBy(xpath = "//input[@value='Send Payment']")
    WebElement sendPaymentBtn;

    public void enterPayeeName(String value){
        sendKeys(payeeName, value);
    }

    public void enterPayeeStreet(String value){
        sendKeys(payeeStreet, value);
    }

    public void enterPayeeCity(String value){
        sendKeys(payeeCity, value);
    }

    public void enterPayeeState(String value){
        sendKeys(payeeState, value);
    }

    public void enterPayeeZipcode(String value){
        sendKeys(payeeZipcode, value);
    }

    public void enterPayeePhoneNumber(String value){
        sendKeys(payeePhoneNumber, value);
    }

    public void enterPayeeAccountNumber(String value){
        sendKeys(payeeAccountNumber, value);
    }

    public void verifyPayeeAccountNumber(String value){
        sendKeys(payeeVerifyAccount, value);
    }

    public void enterAmount(String value){
        sendKeys(amount, value);
    }

    public void clickSendPaymentBtn(){
        click(sendPaymentBtn);
    }



}
