package com.otus.driver;

import com.google.inject.Inject;
import com.otus.driver.impl.ChromeWebDriver;
import com.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import support.GuiceScoped;

import java.util.Locale;

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
        return new ChromeWebDriver().newDriver();
      }
      case "safari": {
        return new SafariDriver();
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
}
