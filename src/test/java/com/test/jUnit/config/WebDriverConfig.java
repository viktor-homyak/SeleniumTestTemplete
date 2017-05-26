package com.test.jUnit.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverConfig {
	protected static WebDriver driver;
	protected static String baseURL;
	protected static WebDriverWait wait;
	protected static Actions action;
	public static String pathToDriver;
	private boolean acceptNextAlert = true;

	@Before
	public void setup() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		Browser browser = null;
		try {

			input = new FileInputStream("src/test/resources/webdriver.properties");

			// load a properties file
			prop.load(input);
			pathToDriver = prop.getProperty("pathToDriver");
			switch (prop.getProperty("browser").toUpperCase()) {
			case "CHROME":
				browser = Browser.CHROME;
				break;
				case "":
					browser = null;
					break;
			case "FIREFOX":
				browser = Browser.FIREFOX;
				break;
			default:
				throw new Exception("Spesify browser name in property file");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		driver = new WebDriverFactory().getDriver(browser);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		baseURL = prop.getProperty("baseURL");

		wait = new WebDriverWait(driver, 30);
		action = new Actions(driver);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	protected String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
