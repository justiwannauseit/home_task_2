package com.otus.steps.common;

import com.google.inject.Inject;
import io.cucumber.java.ru.Но;
import org.junit.jupiter.api.Assertions;
import support.GuiceScoped;

public class CommonPageSteps {

    @Inject
    private GuiceScoped guiceScoped;

    @Но("URL страницы содержит {string}")
    public void urlPageShouldBeContains(String expectedCategory) {
        String currentPageUrl = guiceScoped.driver.getCurrentUrl();
        Assertions.assertTrue(currentPageUrl.contains(expectedCategory));
    }


}
