package com.ericorporation.autotesting.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class ActionOnPage {

    private final WebDriver webDriver;

    public ActionOnPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void clickLinkByText(String linkText) {
        webDriver.findElement(By.linkText(linkText)).click();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
