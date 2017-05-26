package com.test.jUnit.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.test.jUnit.config.WebDriverConfig.pathToDriver;

//TODO not tested.
public class FireFoxWebDriver {

	public WebDriver getDriver() {

		System.setProperty("webdriver.gecko.driver", pathToDriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
