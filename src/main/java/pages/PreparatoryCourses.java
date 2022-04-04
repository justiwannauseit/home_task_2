package pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.GuiceScoped;
import utill.CustomSorter;

import java.util.List;
import java.util.stream.Collectors;

public class PreparatoryCourses extends BasePage<PreparatoryCourses> {


    @FindBy(xpath = ".//div[contains(@class, 'price')]")
    List<WebElement> prices;

    private final static String COURSES_BY_TEXT = ".//*[text()[contains(normalize-space(.),'%s')]]//ancestor::div[contains(@class, 'lessons__new-item-container')]";

    @Inject
    public PreparatoryCourses(GuiceScoped guiceScoped, String path) {
        super(guiceScoped, "/online");
    }

    public void printToCheapCourse() {
        List<WebElement> elements = sortElementsViaComparator(prices, CustomSorter.sortWebElementsByPrice);
        List<WebElement> filteredElements = elements.stream().filter(element -> !element.getText().contains(elements.get(0).getText())).collect(Collectors.toList());
        if (filteredElements.isEmpty()) {
            System.out.println("Среди всех курсов нет самого дешевого");
            return;
        }
        filteredElements.forEach(webElement -> System.out.println("Самые дешевые курсы: " + guiceScoped.driver.findElement(By.xpath(String.format(COURSES_BY_TEXT, webElement.getText()))).getText()));
    }

    public void printToExpensiveCourse() {
        List<WebElement> elements = sortElementsViaComparator(prices, CustomSorter.sortWebElementsByPrice);
        List<WebElement> filteredElements = elements.stream().filter(element -> !element.getText().contains(elements.get(elements.size() - 1).getText())).collect(Collectors.toList());
        if (filteredElements.isEmpty()) {
            System.out.println("Среди всех курсов нет самого дорого");
            return;
        }
        filteredElements.forEach(webElement -> System.out.println("Самые дорогие курсы: " + guiceScoped.driver.findElement(By.xpath(String.format(COURSES_BY_TEXT, webElement.getText()))).getText()));
    }

}
