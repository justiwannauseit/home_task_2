package com.otus.components;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CategoryLessonsPage;
import support.GuiceScoped;
import utill.CustomDataFormatter;
import utill.CustomSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NavigationMenuComponent extends BaseComponent<NavigationMenuComponent> {

    @FindBy(css = ".nav:not(.hide-xs) .course-categories__nav-box")
    private WebElement navComponent;

    @FindBy(xpath = ".//div[contains(@class, 'lessons__new-item-start')]")
    private List<WebElement> popularLessons;

    @FindBy(xpath = ".//div[contains(@class, 'lessons')]/div[contains(@class, 'lessons__new-item-time')]")
    private List<WebElement> specLessons;

    @FindBy(xpath = ".//div[contains(@class, 'lessons__new-item-title')]")
    private List<WebElement> lessonNames;

    private final static String LESSON_CONTAINER = ".//div[text()[contains(normalize-space(.),'%s')]]/ancestor::div[contains(@class, 'lessons__new-item-container')]";
    private final static String LESSON_NAME = ".//div[text()[contains(normalize-space(.),'%s')]]//ancestor::div[contains(@class, 'item-container')]/div[contains(@class, 'title')]";
    private final static String BY_TEXT = ".//*[text()[contains(normalize-space(.),'%s')]]";

    @Inject
    public NavigationMenuComponent(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public CategoryLessonsPage clickNavItem(String itemName) {
        navComponent.findElement(By.cssSelector(String.format("a[title='%s']", itemName))).click();
        return new CategoryLessonsPage(guiceScoped);
    }

    public void getInfoAboutCoursesAfterDate(String value) {
        List<WebElement> datesAfter = filterElementsViaPredicate(getAllCourses(), CustomSorter.filterAfterDate(CustomDataFormatter.stringDateToData(value)));
        datesAfter.forEach(webElement -> System.out.println(guiceScoped.driver.findElement(By.xpath(String.format(LESSON_NAME, webElement.getText()))).getText()));
    }


    public void clickIfContains(String value) {
        clickElementByPredicate.accept(By.xpath(String.format(LESSON_CONTAINER, value)), Objects::nonNull);
    }

    public void clickToElementInDropdown(String contextName, String courseName) {
        clickElementByPredicate.accept(By.xpath(String.format(BY_TEXT, contextName)), Objects::nonNull);
        clickElementByPredicate.accept(By.xpath(String.format(BY_TEXT, courseName)), Objects::nonNull);
    }

    private List<WebElement> getAllCourses() {
        List<WebElement> courses = new ArrayList<>(popularLessons);
        courses.addAll(specLessons);
        return courses;
    }

}
