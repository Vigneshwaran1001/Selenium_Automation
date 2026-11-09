package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPaymentCompletePage extends BaseClass {

    public BillPaymentCompletePage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(xpath = "//h1[text()='Bill Payment Complete']")
    WebElement billPaymentCompleteHeading;

    @FindBy(id = "billpayResult")
    WebElement billPaymentSuccessMessage;

    public String getPageHeading(){
        explicitWait1(billPaymentCompleteHeading);
        return getText(billPaymentCompleteHeading);
    }

    public String getSuccessMessage(){
        explicitWait1(billPaymentSuccessMessage);
        return getText(billPaymentSuccessMessage);
    }
}
