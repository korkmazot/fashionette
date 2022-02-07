package com.fashionette.tests;

import com.fashionette.pages.BasePage;
import com.fashionette.utilities.BrowserUtilities;
import com.fashionette.utilities.ConfigurationReader;
import com.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class Scenerio_01 extends TestBase {

    BasePage basePage = new BasePage();
    @Test
    public void scenerio1() throws InterruptedException {


        String title = driver.getTitle();
        Assert.assertEquals(title,"fashionette | Designer Handtaschen, Schuhe, Accessoires & Beauty online kaufen");
        Thread.sleep(5000);
        WebElement shadowHost = Driver.get().findElement(By.cssSelector("#usercentrics-root"));
        Object shadowRoot = ((JavascriptExecutor) Driver.get()).executeScript("return arguments[0].shadowRoot", shadowHost);
        String id = (String) ((Map<String, Object>) shadowRoot).get("shadow-6066-11e4-a52e-4f735466cecf");
        RemoteWebElement shadowRootElement = new RemoteWebElement();
        shadowRootElement.setParent((RemoteWebDriver) Driver.get());
        shadowRootElement.setId(id);
        WebElement acceptCookiesButton = shadowRootElement.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        acceptCookiesButton.click();
        BrowserUtilities.waitToBeClickable(basePage.bag);

        basePage.bag.click();
        basePage.valentino.click();
        basePage.basket.click();
        basePage.buyButton.click();
        basePage.checkOut.click();
        basePage.username.sendKeys(ConfigurationReader.get("username"));
        basePage.password.sendKeys(ConfigurationReader.get("password"));
        basePage.login.click();
        basePage.continueButton.click();
        basePage.confirmAddressButton.click();
        basePage.selectPayPal.click();

        Assert.assertEquals(basePage.cartItemBrand.getText(),basePage.productTitle.getText());
        Assert.assertEquals(basePage.cartItemQuantity.getText(),"1");



    }
}
