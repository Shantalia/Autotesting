package com.ericorporation.autotesting.ericorporation.ru;

import com.ericorporation.autotesting.action.SignInAction;
import com.ericorporation.autotesting.browser.ChromeDriverInstaller;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class SoftDownload {
    private WebDriver webDriver;
    private SignInAction action;

    @Before
    public void openWindow() {
        webDriver = new ChromeDriverInstaller().getDriver();
        action = new SignInAction(webDriver);
    }
}

