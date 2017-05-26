package com.test.jUnit.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.test.jUnit.config.WebDriverConfig.pathToDriver;

public class ChromeWebDriver  {

	public WebDriver getDriver() {

		System.setProperty("webdriver.chrome.driver",
				pathToDriver);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(1024,768));
		return driver;

	}

}
