package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountOpenedPage extends BaseClass {
    public AccountOpenedPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath = "//h1[text()='Account Opened!']")
    WebElement accountOpenedHeading;

    @FindBy(xpath = "//p[contains(text(),'Congratulations')]")
    WebElement accountOpenedMessage;

    @FindBy(linkText = "Accounts Overview")
    WebElement accountsOverviewLink;

    public String getPageHeading(){
        explicitWait1(accountOpenedHeading);
        return getText(accountOpenedHeading);
    }

    public String getSuccessMessage(){
        return getText(accountOpenedMessage);
    }

    public void clickAccountsOverview(){
        explicitWait1(accountsOverviewLink);
        click(accountsOverviewLink);
    }
}
