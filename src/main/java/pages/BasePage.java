package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;

public abstract class BasePage<T> {

  protected GuiceScoped guiceScoped;
  private String path;

  public BasePage(GuiceScoped guiceScoped, String path) {
    this.guiceScoped = guiceScoped;
    this.path = path;
    PageFactory.initElements(guiceScoped.driver, this);
  }

  @FindBy(tagName = "h1")
  private WebElement header;

  public T open() {
    guiceScoped.driver.get(System.getProperty("base.url"));

    return (T) this;
  }

  public T pageHeaderShouldBeSameAs(String header) {
    assert this.header.getText().equals(header): "Error: Заголовок на странице не корректный";

    return (T) this;
  }

}
