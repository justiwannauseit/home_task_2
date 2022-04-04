package com.otus.driver;

import com.google.inject.Inject;
import com.otus.driver.impl.ChromeCustomDriver;
import com.otus.driver.impl.FirefoxCustomDriver;
import com.otus.driver.impl.OperaCustomDriver;
import com.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;
import support.GuiceScoped;

public class DriverFactory implements IDriverFactory {

    public GuiceScoped guiceScoped;

    @Inject
    public DriverFactory(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    @Override
    public WebDriver getDriver() {
        switch (guiceScoped.browserName) {
            case "chrome": {
                return new ChromeCustomDriver().newDriver();
            }
            case "opera": {
                return new OperaCustomDriver().newDriver();
            }
            case "firefox": {
                return new FirefoxCustomDriver().newDriver();
            }
            default:
                try {
                    throw new DriverTypeNotSupported(guiceScoped.browserName);
                } catch (DriverTypeNotSupported ex) {
                    ex.printStackTrace();
                    return null;
                }
        }
    }

    public void configureDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

}
