package pages;

import actions.CommonActions;
import lombok.extern.java.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;

@Log
public abstract class BasePage<T> extends CommonActions<T> {

    private String path;

    public BasePage(GuiceScoped guiceScoped, String path) {
        super(guiceScoped);
        this.path = path;
        PageFactory.initElements(guiceScoped.driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement header;

    public T open() {
        try {
            guiceScoped.driver.get(System.getProperty("base.url"));
        } catch (NullPointerException e) {
            guiceScoped.driver.get("https://otus.ru");
        }

        return (T) this;
    }

    public T pageHeaderShouldBeSameAs(String header) {
        assert this.header.getText().equals(header) : "Error: Заголовок на странице не корректный";

        return (T) this;
    }

    public String getTitle() {
        return guiceScoped.driver.getTitle();
    }

}
