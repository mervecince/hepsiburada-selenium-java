package org.hepsiburada.hook;

import org.hepsiburada.driver.DriverManager;
import org.hepsiburada.helper.ConfigurationHelper;
import org.hepsiburada.report.ExtentReporter;
import org.openqa.selenium.WebDriver;

public class Hook {
    protected static WebDriver driver;

    protected void hookBefore(){
        driver = new DriverManager().createDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ConfigurationHelper.getInstance().getConfiguration().getUrl());
    }

    protected void hookAfter(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }

    protected static void hookBeforeClass(){
        ExtentReporter.initialize();
    }

    protected static void hookAfterClass(){
        ExtentReporter.flush();
    }
}
