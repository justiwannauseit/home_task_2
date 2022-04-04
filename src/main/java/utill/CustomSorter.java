package utill;

import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;

import static utill.CustomDataFormatter.stringDateToData;
import static utill.CustomDataFormatter.stringToStringDate;

public class CustomSorter {

    private CustomSorter() {
    }

    public static final Comparator<WebElement> sortWebElementsByDate = Comparator
            .comparing(el -> stringDateToData(stringToStringDate(el.getText())));


    public static final Comparator<WebElement> sortWebElementsByAlphabetical = Comparator.comparing(WebElement::getText);

    public static Predicate<WebElement> filterAfterDate(Date date) {
        return webElement -> CustomDataFormatter.stringDateToData(CustomDataFormatter.stringToStringDate(webElement.getText())).after(date);
    }

    public static final Comparator<WebElement> sortWebElementsByPrice = Comparator.comparing(el -> Integer.parseInt(el.getText().replaceAll(" ₽", "")));

}
