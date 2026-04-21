package base;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver d) {
        driver.set(d);
    }

    // Existing instance method (keep this)
    public WebDriver getDriver() {
        return driver.get();
    }

    // NEW static method for listeners/utilities
    public static WebDriver getCurrentDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}