package com.otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import pages.CategoryLessonsPage;

public class CategoryLessonPageSteps {

    @Inject
    private CategoryLessonsPage categoryLessonsPage;

    @Тогда("^На странице отображается заголовок (.*)$")
    public void pageHeaderShouldBeSameAs(String expectedHeader) {
        categoryLessonsPage.pageHeaderShouldBeSameAs(expectedHeader);
    }

    @Тогда("^Страница курса имеет следующий title (.*)$")
    public void pageTitleShouldBeSameAs(String title) {
        Assertions.assertTrue(categoryLessonsPage.getTitle().contains(title));
    }

}
