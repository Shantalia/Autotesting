package com.ericorporation.autotesting;

import com.ericorporation.autotesting.action.SignIn;
import com.ericorporation.autotesting.action.UpdatePass;
import com.ericorporation.autotesting.browser.ChromeDriverInstaller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ericorporation.autotesting.constant.WebPath.*;

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
        if (webDriver.getCurrentUrl().toString().equals("https://ericorporation.ru/sign-in/?status=failed"))
        {
            actionSignIn.fillUserLogin("test@gmail.com");
            actionSignIn.fillUserPassword("123456");

            Thread.sleep(1000);
            actionSignIn.clickSubmitButton();
        }
        else
        {
            System.out.print(webDriver.getCurrentUrl().toString());
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

        do {
            if (webDriver.findElement(By.className("bad")).getText().toString().equals("New/old password is not correct or you entered your old password!"))
            {
                Thread.sleep(1000);
                actionUpdPass.fillOldPassword("123456");
                actionUpdPass.fillNewPassword("test123");
                actionUpdPass.repeatNewPassword("test123");

                Thread.sleep(1000);
                actionUpdPass.clickChangePasswordSubmitButton();
            }
            else Assert.assertEquals(webDriver.findElement(By.className("good")).getText().toString(),"Your password has successfully updated!");
        } while (webDriver.findElement(By.className("good")).getText().toString().equals("Your password has successfully updated!"));

        Thread.sleep(2000);
        webDriver.close();
    }
}

