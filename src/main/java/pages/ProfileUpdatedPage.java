package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileUpdatedPage extends BaseClass {

    public ProfileUpdatedPage(WebDriver dr){
        this.driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(xpath = "//h1[text()='Profile Updated']")
    WebElement profileUpdatedHeading;

    public String getProfileUpdatedHeading(){
        explicitWait1(profileUpdatedHeading);
        return getText(profileUpdatedHeading);
    }
}
