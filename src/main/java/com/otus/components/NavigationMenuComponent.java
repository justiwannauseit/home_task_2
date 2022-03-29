package com.otus.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CategoryLessonsPage;

public class NavigationMenuComponent extends BaseComponent<NavigationMenuComponent> {

  @FindBy(css = ".nav:not(.hide-xs) .course-categories__nav-box")
  private WebElement navComponent;

  public NavigationMenuComponent(WebDriver driver) {
    super(driver);
  }

  public CategoryLessonsPage clickNavItem(String itemName) {
    navComponent.findElement(By.cssSelector(String.format("a[title='%s']", itemName))).click();

    return new CategoryLessonsPage(driver);
  }

}
