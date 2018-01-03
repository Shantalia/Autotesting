package com.ericorporation.autotesting;

import com.ericorporation.autotesting.action.SignIn;
import com.ericorporation.autotesting.action.UpdatePass;
import com.ericorporation.autotesting.browser.ChromeDriverInstaller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.ericorporation.autotesting.constant.WebPath.*;
import com.ericorporation.autotesting.action.UpdatePass;

public class PasswordUpdaterTest {
    private WebDriver webDriver;
    private SignIn actionSignIn;
    private UpdatePass actionUpdPass;

    @Before
    public void setFields() {
        webDriver = new ChromeDriverInstaller().getDriver();
        actionSignIn = new SignIn(webDriver);
        actionUpdPass = new UpdatePass(webDriver);
    }

    @Test
    public void testUpdatePassWithValidData() throws InterruptedException {

        webDriver.get(INDEX);

        Thread.sleep(3000);
        actionSignIn.acceptCookie();

        Thread.sleep(1000);
        actionSignIn.clickSignIn();

        Thread.sleep(1000);
        actionSignIn.fillUserLogin("test@gmail.com");
        actionSignIn.fillUserPassword("test123");

        Thread.sleep(1000);
        actionSignIn.clickSubmitButton();

        Thread.sleep(1000);
        actionUpdPass.openProfileMenu();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ericorporation.ru/selection-software-for-heat-exchanger/");

//        Thread.sleep(2000);
//        webDriver.close();
    }
}

