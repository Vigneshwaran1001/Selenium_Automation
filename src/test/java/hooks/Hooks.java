package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Hooks extends BaseClass {

    @Before
    public void launchBrowser() throws IOException {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerLeakDetection");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void closeBrowser(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
