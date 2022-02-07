package com.fashionette.tests;

import com.fashionette.pages.BasePage;
import com.fashionette.pages.LoginPage;
import com.fashionette.pages.ModifyPage;
import com.fashionette.utilities.BrowserUtilities;
import com.fashionette.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenerio_02 extends TestBase {

    @Test
    public void scenerio2() throws InterruptedException {
        BasePage basePage = new BasePage();
        LoginPage loginPage = new LoginPage();
        ModifyPage modifyPage = new ModifyPage();

        Thread.sleep(3000);
        BrowserUtilities.acceptCookies();
        BrowserUtilities.waitToBeClickable(basePage.userIcon);

        basePage.userIcon.click();
        Thread.sleep(2000);
        BrowserUtilities.waitForPageToLoad(15);
        loginPage.username.sendKeys(ConfigurationReader.get("username"));
        loginPage.password.sendKeys(ConfigurationReader.get("password"));
        loginPage.login.click();
        BrowserUtilities.waitForPageToLoad(10);
        modifyPage.personliche.click();
        modifyPage.bearbeiten.click();
        modifyPage.vorname.clear();
        modifyPage.vorname.sendKeys("Mike");
        modifyPage.nachname.clear();
        modifyPage.nachname.sendKeys("Smith");
        modifyPage.save.click();
        modifyPage.edited.click();

        Assert.assertEquals(modifyPage.editedTitle.getText(),"Mike");
        System.out.println(modifyPage.editedTitle.getText());

    }
}
