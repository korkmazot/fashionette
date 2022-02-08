package com.fashionette.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;

public class BrowserUtilities {

    public static WebElement waitToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void acceptCookies() throws InterruptedException {
        WebElement shadowHost = Driver.get().findElement(By.cssSelector("#usercentrics-root"));
        Object shadowRoot = ((JavascriptExecutor) Driver.get()).executeScript("return arguments[0].shadowRoot", shadowHost);
        String id = (String) ((Map<String, Object>) shadowRoot).get("shadow-6066-11e4-a52e-4f735466cecf");
        RemoteWebElement shadowRootElement = new RemoteWebElement();
        shadowRootElement.setParent((RemoteWebDriver) Driver.get());
        shadowRootElement.setId(id);
        WebElement acceptCookiesButton = shadowRootElement.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        acceptCookiesButton.click();
    }
        public static void waitForPageToLoad(long timeOutInSeconds) {
            ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };
            try {
                WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
                wait.until(expectation);
            } catch (Throwable error) {
                error.printStackTrace();
            }
        }


    public static int valueConverter(String numberInWord){
        numberInWord = numberInWord.substring(0, numberInWord.indexOf(" "));
        int number = Integer.parseInt(numberInWord);
        return number;
    }

    }

