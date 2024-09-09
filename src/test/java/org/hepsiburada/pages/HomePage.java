package org.hepsiburada.pages;

import org.hepsiburada.base.StepImpl;
import org.hepsiburada.helper.MethodCall;
import org.hepsiburada.report.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends StepImpl {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By cookie = By.id("onetrust-accept-btn-handler");
    By searchArea = By.cssSelector(".SearchBoxOld");
    By searchInput = By.cssSelector("input[class*='searchBarContent']");

    public void waitPage(){
        wait(3);
        waitPageLoad();
        click(cookie);
    }

    public void search(String text){
        ExtentReporter.createNode(MethodCall.getCallingMethodName());
        ExtentReporter.setNodeLogInfo("WebElement: searchArea");
        ExtentReporter.setNodeLogInfo("WebElement: searchInput");
        ExtentReporter.setNodeLogInfo("Text: "+text);
        ExtentReporter.setNodeLogInfo("Class: "+this.getClass().getSimpleName());
        waitElement(searchArea);
        waitClickable(searchArea);
        click(searchArea);
        wait(2);
        click(searchArea);
        sendKey(searchInput, text);
        sendKeyEnter(searchInput);
    }
}
