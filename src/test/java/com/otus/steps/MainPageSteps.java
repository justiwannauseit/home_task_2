package com.otus.steps;

import com.otus.components.NavigationMenuComponent;
import com.otus.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageSteps {

  private WebDriver driver = null;

  private MainPage mainPage = null;

  @Before
  public void initDriver() {
    driver = new DriverFactory().getDriver();
  }

  @After
  public void closeDriver() {
    if(driver != null) {
      driver.close();
      driver.quit();
    }
  }

  @Пусть("^Открыта главная страница otus в браузере$")
  public void openMainPage() {
    mainPage = new MainPage(driver)
        .open();
  }

  @Тогда("Главная страница открыта и заголовок {string}")
  public void pageShouldBeOpened(String expectedHeader) {
    mainPage.pageHeaderShouldBeSameAs(expectedHeader);
  }

  @Если("Кликнуть на категорию курса {string}")
  public void clickNavMenuItem(String itemName) {
    new NavigationMenuComponent(driver).clickNavItem(itemName);
  }

}
