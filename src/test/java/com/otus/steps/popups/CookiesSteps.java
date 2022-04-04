package com.otus.steps.popups;

import com.google.inject.Inject;
import io.cucumber.java.ru.Ктомуже;
import lombok.extern.java.Log;
import popups.Cookies;

@Log
public class CookiesSteps {

    @Inject
    private Cookies cookies;

    @Ктомуже("Приняты все куки")
    public void clickToCookieButton() {
        cookies.clickToOkButton();
    }

}
