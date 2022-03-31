package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.components.NavigationMenuComponent;
import com.otus.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import support.GuiceScoped;

import java.sql.Time;

public class MainPageSteps {

  @Inject
  private DriverFactory driverFactory;
  @Inject
  private GuiceScoped guiceScoped;
  @Inject
  private MainPage mainPage;

  @Пусть("^Открыта главная страница otus в браузере$")
  public void openMainPage() {
    guiceScoped.browserName = "chrome";
    guiceScoped.driver = driverFactory.getDriver();
    mainPage.open();
  }

  @Тогда("Главная страница открыта и заголовок {string}")
  public void pageShouldBeOpened(String expectedHeader) {
    mainPage.pageHeaderShouldBeSameAs(expectedHeader);
  }

}
