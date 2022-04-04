package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.driver.DriverFactory;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;
import support.GuiceScoped;

public class MainPageSteps {

    @Inject
    private DriverFactory driverFactory;
    @Inject
    private GuiceScoped guiceScoped;
    @Inject
    private MainPage mainPage;

    @Пусть("^Открыта главная страница otus в браузере (chrome|opera|firefox)$")
    public void openMainPage(String browserName) {
        guiceScoped.browserName = browserName;
        guiceScoped.driver = driverFactory.getDriver();
        guiceScoped.actions = new Actions(guiceScoped.driver);
        driverFactory.configureDriver(guiceScoped.driver);
        mainPage.open();
    }

    @Тогда("Главная страница открыта и заголовок {string}")
    public void pageShouldBeOpened(String expectedHeader) {
        mainPage.pageHeaderShouldBeSameAs(expectedHeader);
    }

}
