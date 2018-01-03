package com.ericorporation.autotesting.browser;

public enum Browser {

    CHROME(new ChromeDriverInstaller());

    DriverInstaller driverInstaller;

    public DriverInstaller getDriverInstaller() {
        return driverInstaller;
    }

    Browser(DriverInstaller driverInstaller) {
        this.driverInstaller = driverInstaller;
    }
}
