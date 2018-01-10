package com.ericorporation.autotesting.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInAction extends ActionOnPage {

    public SignInAction(WebDriver webDriver) {
        super(webDriver);
    }

    public void acceptCookie() {
        getWebDriver().findElement(By.className("tplis-cl-button-accept")).click();
    }

    public void clickSignIn(String signLink) {
        clickLinkByText(signLink);
    }

    public void fillUserLogin(String login) {
        getWebDriver().findElement(By.id("user_login1")).sendKeys(login);
    }

    public void fillUserPassword(String password) {
        getWebDriver().findElement(By.id("user_pass1")).sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement submitButton = getWebDriver().findElement(By.id("wp-submit1"));
        submitButton.click();
    }

}
