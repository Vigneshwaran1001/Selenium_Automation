package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    public HomePage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginBtn;

    @FindBy(xpath = "//h2[text()='Customer Login']")
    WebElement pageHeading;

    public void clickRegister(){
        click(registerLink);
    }

    public void enterUserName(String name){
        sendKeys(userName, name);
    }

    public void enterPassword(String value){
        sendKeys(password, value);
    }

    public void clickLoginBtn(){
        click(loginBtn);
    }

    public String getPageHeading(){
        explicitWait1(pageHeading);
        return getText(pageHeading);
    }

}
