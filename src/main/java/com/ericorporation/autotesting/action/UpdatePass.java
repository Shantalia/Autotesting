package com.ericorporation.autotesting.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdatePass extends ActionOnPage {

    public UpdatePass (WebDriver webDriver) { super(webDriver);}

    public void openProfileMenu() {
        getWebDriver().findElement(By.className("logged")).click();
        System.out.print("done");
    }

}
