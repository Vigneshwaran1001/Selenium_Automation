package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    protected static WebDriver driver;

    public static void click(WebElement element){
        element.click();
    }

    public static void sendKeys(WebElement element, String value){
        element.sendKeys(value);
    }

    public static String getText(WebElement element){
        return element.getText();
    }

    public static void selectByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void explicitWait1(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png");
        FileUtils.copyFile(source, destination);
    }
}
