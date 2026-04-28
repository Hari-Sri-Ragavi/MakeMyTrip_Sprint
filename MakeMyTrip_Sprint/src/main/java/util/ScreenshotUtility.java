package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
    public String capture(WebDriver driver, String name) {
        String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                .format(new Date());
        String path = "./target/Reports/Screenshots/"
                + name.replaceAll("[^a-zA-Z0-9]", "_")
                + "_" + time + ".png";
        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            FileHandler.copy(src, dest);
            return dest.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}