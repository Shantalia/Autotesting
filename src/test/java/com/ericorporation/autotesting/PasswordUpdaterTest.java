package com.ericorporation.autotesting;

import com.ericorporation.autotesting.action.SignIn;
import com.ericorporation.autotesting.action.UpdatePassword;
import com.ericorporation.autotesting.browser.ChromeDriverInstaller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.*;

import javax.xml.bind.Element;

import static com.ericorporation.autotesting.constant.WebPath.*;

public class PasswordUpdaterTest {
    private WebDriver webDriver;
    private SignIn actionSignIn;
    private UpdatePassword actionUpdPass;


    @Before
    public void setFields() {
        webDriver = new ChromeDriverInstaller().getDriver();
        actionSignIn = new SignIn(webDriver);
        actionUpdPass = new UpdatePassword(webDriver);
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
        if (webDriver.getCurrentUrl().equals("https://ericorporation.ru/sign-in/?status=failed"))
        {
            actionSignIn.fillUserLogin("test@gmail.com");
            actionSignIn.fillUserPassword("123456");

            Thread.sleep(1000);
            actionSignIn.clickSubmitButton();
        }
        else
        {
            System.out.print(webDriver.getCurrentUrl());
        }

        Thread.sleep(1000);
        actionUpdPass.openProfileMenu();
        actionUpdPass.goToChangePasswordPage();

        Thread.sleep(1000);
        actionUpdPass.fillOldPassword("test123");
        actionUpdPass.fillNewPassword("123456");
        actionUpdPass.repeatNewPassword("123456");

        Thread.sleep(1000);
        actionUpdPass.clickChangePasswordSubmitButton();

        Thread.sleep(1000);

        if (actionUpdPass.isElementPresent(By.className("bad"))) {
            actionUpdPass.fillOldPassword("123456");
            actionUpdPass.fillNewPassword("test123");
            actionUpdPass.repeatNewPassword("test123");

            Thread.sleep(1000);
            actionUpdPass.clickChangePasswordSubmitButton();
        }

        Assert.assertTrue(webDriver.findElement(By.className("good")).isDisplayed());

        Thread.sleep(2000);
        webDriver.close();
    }

    @Test
    public void testUpdatePassWithEmptyData() throws InterruptedException {

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
        if (webDriver.getCurrentUrl().equals("https://ericorporation.ru/sign-in/?status=failed"))
        {
            actionSignIn.fillUserLogin("test@gmail.com");
            actionSignIn.fillUserPassword("123456");

            Thread.sleep(1000);
            actionSignIn.clickSubmitButton();
        }
        else
        {
            System.out.print(webDriver.getCurrentUrl());
        }

        Thread.sleep(1000);
        actionUpdPass.openProfileMenu();
        actionUpdPass.goToChangePasswordPage();

        Thread.sleep(1000);
        actionUpdPass.fillOldPassword("");
        actionUpdPass.fillNewPassword("");
        actionUpdPass.repeatNewPassword("");

        Thread.sleep(1000);
        actionUpdPass.clickChangePasswordSubmitButton();

        Assert.assertFalse(webDriver.findElement(By.id("cp-submit")).isEnabled());

        Thread.sleep(2000);
        webDriver.close();
    }

    @Test
    public void testUpdatePassWithEmptyFields() throws InterruptedException {

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
        if (webDriver.getCurrentUrl().equals("https://ericorporation.ru/sign-in/?status=failed"))
        {
            actionSignIn.fillUserLogin("test@gmail.com");
            actionSignIn.fillUserPassword("123456");

            Thread.sleep(1000);
            actionSignIn.clickSubmitButton();
        }
        else
        {
            System.out.print(webDriver.getCurrentUrl());
        }

        Thread.sleep(1000);
        actionUpdPass.openProfileMenu();
        actionUpdPass.goToChangePasswordPage();

        Thread.sleep(1000);
        actionUpdPass.fillOldPassword("");
        actionUpdPass.fillNewPassword("");
        actionUpdPass.repeatNewPassword("");

        Thread.sleep(1000);
        actionUpdPass.clickChangePasswordSubmitButton();

        String[] emptyOldPassword = {"","test123"};
        String[] emptyNewPassword = {"","123456"};
        String[] emptyRepetedPassword = {"","123456"};

        do {
            Thread.sleep(1000);
            for(int i=0; i<2; i++) {
                actionUpdPass.fillOldPassword(emptyOldPassword[i]);
                for (int j = 0; j < 2; j++) {
                    actionUpdPass.fillNewPassword(emptyNewPassword[j]);
                    for (int l = 1; l >= 0; l--) {
                        actionUpdPass.repeatNewPassword(emptyRepetedPassword[l]);
                        break;
                    }
                    break;
                }
                break;
            }
        } while (!webDriver.findElement(By.id("cp-submit")).isEnabled());

        Assert.assertFalse(webDriver.findElement(By.id("cp-submit")).isEnabled());

        Thread.sleep(2000);
        webDriver.close();
    }
}

