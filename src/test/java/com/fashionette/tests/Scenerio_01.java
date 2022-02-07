package com.fashionette.tests;

import com.fashionette.pages.BasePage;
import com.fashionette.pages.LoginPage;
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


    @Test
    public void scenerio1() throws InterruptedException {
        BasePage basePage = new BasePage();
        LoginPage loginPage = new LoginPage();

        String title = driver.getTitle();
        Assert.assertEquals(title,"fashionette | Designer Handtaschen, Schuhe, Accessoires & Beauty online kaufen");
        Thread.sleep(5000);
        BrowserUtilities.acceptCookies();
        BrowserUtilities.waitToBeClickable(basePage.bag);

        basePage.bag.click();
        basePage.valentino.click();
        BrowserUtilities.waitForVisibility(basePage.productTitle,10);
        String productTitle = basePage.productTitle.getText();
        basePage.basket.click();
        basePage.userIcon.click();

        Thread.sleep(3000);

       // BrowserUtilities.waitForVisibility(loginPage.username,10);
        //loginPage.username.click();
        loginPage.username.sendKeys(ConfigurationReader.get("username"));
        loginPage.password.sendKeys(ConfigurationReader.get("password"));
        loginPage.login.click();
        basePage.cartIcon.click();

        Assert.assertEquals(basePage.cartItemBrand.getText(),productTitle);

    }
}
