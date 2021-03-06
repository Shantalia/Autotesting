package com.ericorporation.autotesting.ericorporation.de;

import com.ericorporation.autotesting.action.SignInAction;
import com.ericorporation.autotesting.browser.ChromeDriverInstaller;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.ericorporation.autotesting.constant.WebPath.INDEX_DE;

public class SignInActionTest {

    private WebDriver webDriver;
    private SignInAction action;

    @Before
    public void openWindow() {
        webDriver = new ChromeDriverInstaller().getDriver();
        action = new SignInAction(webDriver);
    }


    @Test
    public void testSignInWithValidData() throws InterruptedException {

        webDriver.get(INDEX_DE);

        Thread.sleep(3000);
        action.acceptCookie();

        Thread.sleep(1000);
        action.clickSignIn("ANMELDEN");

        Thread.sleep(1000);
        action.fillUserLogin("test@gmail.com");
        action.fillUserPassword("test123");

        Thread.sleep(1000);
        action.clickSubmitButton();

        Thread.sleep(1000);
            if (webDriver.getCurrentUrl().equals("https://ericorporation.de/anmelden/?status=failed")) {
                action.fillUserLogin("test@gmail.com");
                action.fillUserPassword("123456");

                Thread.sleep(1000);
                action.clickSubmitButton();
            }
            else { System.out.print(webDriver.getCurrentUrl()); }

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ericorporation.de/auslegungsprogramm/");

        Thread.sleep(2000);
    }

    @Test
    public void testSignInWithEmptyData() throws InterruptedException {

        webDriver.get(INDEX_DE);

        Thread.sleep(3000);
        action.acceptCookie();

        Thread.sleep(1000);
        action.clickSignIn("ANMELDEN");

        Thread.sleep(1000);
        action.fillUserLogin("");
        action.fillUserPassword("");

        Thread.sleep(1000);
        action.clickSubmitButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ericorporation.de/anmelden/?status=empty");

        Thread.sleep(3000);
    }

    @Test
    public void testSignInWithReverseData() throws InterruptedException {

        webDriver.get(INDEX_DE);

        Thread.sleep(3000);
        action.acceptCookie();

        Thread.sleep(1000);
        action.clickSignIn("ANMELDEN");

        Thread.sleep(1000);
        action.fillUserLogin("test123");
        action.fillUserPassword("test@gmail.com");

        Thread.sleep(1000);
        action.clickSubmitButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ericorporation.de/anmelden/?status=failed");

        Thread.sleep(3000);
    }

    @Test
    public void testSignInWithEmptyPassword() throws InterruptedException {

        webDriver.get(INDEX_DE);

        Thread.sleep(3000);
        action.acceptCookie();

        Thread.sleep(1000);
        action.clickSignIn("ANMELDEN");

        Thread.sleep(1000);
        action.fillUserLogin("test@gmail.com");
        action.fillUserPassword("");

        Thread.sleep(1000);
        action.clickSubmitButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ericorporation.de/anmelden/?status=empty");

        Thread.sleep(3000);
    }

    @Test
    public void testSignInWithEmptyLogin() throws InterruptedException {

        webDriver.get(INDEX_DE);

        Thread.sleep(3000);
        action.acceptCookie();

        Thread.sleep(1000);
        action.clickSignIn("ANMELDEN");

        Thread.sleep(1000);
        action.fillUserLogin("");
        action.fillUserPassword("test123");

        Thread.sleep(1000);
        action.clickSubmitButton();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ericorporation.de/anmelden/?status=empty");

        Thread.sleep(3000);
    }

    @After
    public void closeWebDriver(){
        webDriver.close();
    }
}
