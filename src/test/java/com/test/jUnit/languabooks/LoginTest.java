package com.test.jUnit.languabooks;

/**
 * Created by vhomyak on 17.05.2017.
 */

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.test.jUnit.config.WebDriverConfig;

public class LoginTest extends WebDriverConfig{




    @Test
    public void test() throws Exception {
        driver.get(baseURL + "/#/login");
        driver.findElement(By.cssSelector("img")).click();
        driver.findElement(By.id("steamPassword")).clear();
        driver.findElement(By.id("steamPassword")).sendKeys("EBdPKzC3");
        driver.findElement(By.id("steamAccountName")).clear();
        driver.findElement(By.id("steamAccountName")).sendKeys("h_vitya");
        driver.findElement(By.id("imageLogin")).click();
    }

}
