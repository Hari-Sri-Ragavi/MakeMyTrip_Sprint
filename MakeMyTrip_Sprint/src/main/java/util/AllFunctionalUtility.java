package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class AllFunctionalUtility {

    public String readDataFromPropertiesFile(String key) throws IOException {
        
        String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        FileInputStream fis = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(fis);
        fis.close(); 
        return prop.getProperty(key);
    }

    public void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}