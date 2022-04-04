package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import support.GuiceScoped;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class CommonActions<T> {

    protected GuiceScoped guiceScoped;

    public CommonActions(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    protected BiConsumer<By, Predicate<? super WebElement>> clickElementByPredicate = (By locator, Predicate<? super WebElement> predicate) -> {
        List<WebElement> elements = guiceScoped.driver.findElements(locator).stream().filter(predicate).collect(Collectors.toList());
        if (!elements.isEmpty()) {
            WebElement element;
            element = elements.stream().reduce((first, second) -> (int) (Math.random() * 1) == 0 ? first : second).get();
            guiceScoped.actions.moveToElement(element).sendKeys(Keys.DOWN).pause(800).build().perform();
            element.click();
        }
    };

    protected List<WebElement> sortElementsViaComparator(List<WebElement> elements, Comparator<WebElement> comparator) {
        return elements.stream().sorted(comparator).collect(Collectors.toList());
    }

    protected List<WebElement> filterElementsViaPredicate(List<WebElement> elements, Predicate<WebElement> filter) {
        return elements.stream().filter(filter).collect(Collectors.toList());
    }

}
