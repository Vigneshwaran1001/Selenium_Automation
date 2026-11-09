package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage extends BaseClass {
    public AccountOverviewPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Accounts Overview']")
    WebElement accountOverviewHeading;

    @FindBy(linkText = "Open New Account")
    WebElement openNewAccountLink;

    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(linkText = "Bill Pay")
    WebElement billPayLink;

    @FindBy(linkText = "Update Contact Info")
    WebElement updateContactInfoLink;

    @FindBy(linkText = "Request Loan")
    WebElement requestLoanLink;

    public String getPageHeading(){
        explicitWait1(accountOverviewHeading);
        return getText(accountOverviewHeading);
    }

    public void clickOpenNewAccountLink(){
        click(openNewAccountLink);
    }

    public void clickLogoutLink(){
        explicitWait1(logoutLink);
        click(logoutLink);
    }

    public void clickTransferFundsLink(){
        click(transferFundsLink);
    }

    public void clickBillPayLink(){
        click(billPayLink);
    }

    public void clickRequestLoanLink(){
        click(requestLoanLink);
    }





}
