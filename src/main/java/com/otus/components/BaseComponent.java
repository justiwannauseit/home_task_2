package com.otus.components;

import actions.CommonActions;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;

public abstract class BaseComponent<T> extends CommonActions<T> {

  protected GuiceScoped guiceScoped;

  public BaseComponent(GuiceScoped guiceScoped) {
    super(guiceScoped);
    PageFactory.initElements(guiceScoped.driver, this);
    this.guiceScoped = guiceScoped;
  }

}
