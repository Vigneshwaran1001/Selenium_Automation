package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferCompletePage extends BaseClass {

    public TransferCompletePage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(xpath = "//h1[text()='Transfer Complete!']")
    WebElement transferCompleteHeading;

    public String getTransferCompleteHeading(){
        explicitWait1(transferCompleteHeading);
        return getText(transferCompleteHeading);
    }
}
