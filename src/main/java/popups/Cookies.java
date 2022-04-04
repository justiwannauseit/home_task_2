package popups;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.GuiceScoped;

public class Cookies extends AnyPopupAbs<Cookies> {

    @FindBy(xpath = ".//button[contains(@class, 'cookie')]")
    private WebElement cookie;

    @Inject
    public Cookies(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void clickToOkButton() {
        if (cookie.isEnabled()) {
            guiceScoped.actions.pause(999).moveToElement(cookie).pause(400).build().perform();
            cookie.click();
        }
    }

}
