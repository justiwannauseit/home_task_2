package popups;

import actions.CommonActions;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;

public abstract class AnyPopupAbs<T> extends CommonActions<T> {

  protected GuiceScoped guiceScoped;

  public AnyPopupAbs(GuiceScoped guiceScoped) {
    super(guiceScoped);
    PageFactory.initElements(guiceScoped.driver, this);
    this.guiceScoped = guiceScoped;
  }

}
