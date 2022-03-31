package com.otus.steps.common;

import com.google.inject.Inject;
import io.cucumber.java.ru.Но;
import support.GuiceScoped;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonPageSteps {

    @Inject
    private GuiceScoped guiceScoped;

    @Но("URL страницы содержит {string}")
    public void urlPageShouldBeContains(String expectedCategory) {
        String currentPageUrl = guiceScoped.driver.getCurrentUrl();

        String patternStr = String.format("https?:\\/\\/(?:.*?)?otus\\.ru\\/categories\\/?%s/?", expectedCategory);

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(currentPageUrl);

        assert matcher.find(): "Error:";

    }


}
