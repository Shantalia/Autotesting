package com.ericorporation.autotesting.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverInstaller implements DriverInstaller{

    private final WebDriver driver;

    public ChromeDriverInstaller() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
