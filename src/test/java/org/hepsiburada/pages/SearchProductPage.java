package org.hepsiburada.pages;

import org.hepsiburada.base.StepImpl;
import org.hepsiburada.helper.MethodCall;
import org.hepsiburada.report.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage extends StepImpl {

    public SearchProductPage(WebDriver driver){
        super(driver);
    }

    By searchProductList = By.cssSelector("a[class*='moria-ProductCard']");

    public void clickWithIndexProduct(int index){
        waitPageLoad();
        ExtentReporter.createNode(MethodCall.getCallingMethodName());
        ExtentReporter.setNodeLogInfo("WebElement: searchProductList");
        ExtentReporter.setNodeLogInfo("Index: "+ index);
        ExtentReporter.setNodeLogInfo("Class: "+this.getClass().getSimpleName());
        waitListElements(searchProductList);
        waitClickable(searchProductList);
        clickListElementIndex(searchProductList, index);
    }

    public void switchToNewPage(){
        navigateWindow();
        ExtentReporter.createNode(MethodCall.getCallingMethodName());
        ExtentReporter.setNodeLogInfo("Info: navigateNewWindow");
        ExtentReporter.setNodeLogInfo("Class: "+this.getClass().getSimpleName());
        waitPageLoad();
    }
}
