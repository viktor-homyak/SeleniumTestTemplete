package com.test.jUnit.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class WebDriverFactory {

	public WebDriver getDriver(Browser browserName) {
		if (browserName == null) {
            System.out.println("web browser not specified.");
           return null;
		}
		if (browserName.equals(Browser.CHROME)) {
			ChromeWebDriver driver = new ChromeWebDriver();
			return driver.getDriver();

		} else if (browserName.equals(Browser.FIREFOX)) {
			FireFoxWebDriver driver = new FireFoxWebDriver();
			return driver.getDriver();

		}
		return null;
	}
}
