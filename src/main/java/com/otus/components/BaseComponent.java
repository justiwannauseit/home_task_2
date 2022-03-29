package com.otus.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent<T> {

  protected WebDriver driver;

  public BaseComponent(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

}
