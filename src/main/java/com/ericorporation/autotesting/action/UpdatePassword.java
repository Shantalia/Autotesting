package com.ericorporation.autotesting.action;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UpdatePassword extends ActionOnPage {

    public UpdatePassword(WebDriver webDriver) { super(webDriver);}

    public void openProfileMenu() { getWebDriver().findElement(By.id("logged")).click(); }

    public void goToChangePasswordPage() { getWebDriver().findElement(By.className("change-pass")).click();}

    public void fillOldPassword(String oldPassword) { getWebDriver().findElement(By.id("old-pass")).sendKeys(oldPassword); }

    public void fillNewPassword(String newPassword) { getWebDriver().findElement(By.id("new-pass-1")).sendKeys(newPassword); }

    public void repeatNewPassword(String newPassword) { getWebDriver().findElement(By.id("new-pass-2")).sendKeys(newPassword); }

    public void clickChangePasswordSubmitButton()
    {
        WebElement changePasswordSubmitButton = getWebDriver().findElement(By.id("cp-submit"));
        changePasswordSubmitButton.click();
    }

    public boolean isElementPresent(By by) {
        try {
            getWebDriver().findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
