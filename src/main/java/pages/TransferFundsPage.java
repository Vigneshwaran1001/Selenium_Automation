package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage extends BaseClass {

    public TransferFundsPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(id = "amount")
    WebElement amount;

    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    @FindBy(id = "toAccountId")
    WebElement toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transferBtn;

    public void enterAmount(String value){
        sendKeys(amount, value);
    }

    public void selectFromAccount(String account){
        selectByVisibleText(fromAccount, account);
    }

    public void selectToAccount(String account){
        selectByVisibleText(toAccount, account);
    }

    public void clickTransferBtn(){
        click(transferBtn);
    }




}
