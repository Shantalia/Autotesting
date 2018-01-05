package com.ericorporation.autotesting.browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverInstaller implements DriverInstaller{

    private final WebDriver driver;

    public ChromeDriverInstaller() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
