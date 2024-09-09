package org.hepsiburada.pages;

import org.hepsiburada.base.StepImpl;
import org.hepsiburada.helper.MethodCall;
import org.hepsiburada.report.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends StepImpl {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    By productEvaluationButton = By.cssSelector("a[aria-label*='Değerlendirme']");
    By thumbsUpButton = By.xpath("//div[contains(@class, 'thumbsUp')]");
    By thankYouTextArea = By.xpath("(//span[contains(@class, 'hermes-ReviewCard-module') and text()='Teşekkür Ederiz.'])[1]");

    public void clickEvaluationButton(){
        ExtentReporter.createNode(MethodCall.getCallingMethodName());
        ExtentReporter.setNodeLogInfo("WebElement: productEvaluationButton");
        ExtentReporter.setNodeLogInfo("Class: "+this.getClass().getSimpleName());
        waitElement(productEvaluationButton);
        click(productEvaluationButton);
    }

    public void clickThumbsUpButton(){
        ExtentReporter.createNode(MethodCall.getCallingMethodName());
        ExtentReporter.setNodeLogInfo("WebElement: thumbsUpButton");
        ExtentReporter.setNodeLogInfo("Class: "+this.getClass().getSimpleName());
        waitElement(thumbsUpButton);
        scroll(thumbsUpButton);
        click(thumbsUpButton);
    }

    public void checkThankYouTextArea(){
        ExtentReporter.createNode(MethodCall.getCallingMethodName());
        ExtentReporter.setNodeLogInfo("WebElement: thankYouTextArea");
        ExtentReporter.setNodeLogInfo("Class: "+this.getClass().getSimpleName());
        checkElement(thankYouTextArea);
    }
}
