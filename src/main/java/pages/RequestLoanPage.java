package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage extends BaseClass {

    public RequestLoanPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(id = "amount")
    WebElement loanAmount;

    @FindBy(id = "downPayment")
    WebElement downPayment;

    @FindBy(xpath = "//input[@value='Apply Now']")
    WebElement applyNowBtn;

    public void enterLoanAmount(String value){
        sendKeys(loanAmount, value);
    }

    public void enterDownPayment(String value){
        sendKeys(downPayment, value);
    }

    public void clickApplyNowBtn(){
        explicitWait1(applyNowBtn);
        click(applyNowBtn);
    }

}
