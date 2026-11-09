package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanRequestProcessedPage extends BaseClass {

    public LoanRequestProcessedPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(xpath = "//h1[text()='Loan Request Processed']")
    WebElement loanRequestProcessedHeading;

    public String getPageHeading(){
        explicitWait1(loanRequestProcessedHeading);
        return getText(loanRequestProcessedHeading);
    }
}
