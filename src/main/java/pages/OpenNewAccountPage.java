package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage extends BaseClass {

    public OpenNewAccountPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(id = "type")
    WebElement accountTypeDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    WebElement openNewAccountButton;

    public void selectAccountType(String accountType){
        selectByVisibleText(accountTypeDropdown,accountType);
    }

    public void clickOpenNewAccountButton(){
        click(openNewAccountButton);
    }
}
