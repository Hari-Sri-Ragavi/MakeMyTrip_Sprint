package base;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver d) {
        driver.set(d);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}