package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        waitForElementLocatedAndClick(locator,20);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitForElementLocatedAndClick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }
    public void waitForElementClickableAndClick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public boolean isElementPresent(By locator) {
            return wd.findElements(locator).size() > 0;
        }

    public void returnToHomePage(){
        waitForElementClickableAndClick(By.xpath("//span[@name='house']"), 0);
        waitForElementLocatedAndClick(By.xpath("//span[@name='house']"),0);
    }
}
