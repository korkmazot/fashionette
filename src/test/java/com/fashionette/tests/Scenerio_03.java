package com.fashionette.tests;

import com.fashionette.pages.BasePage;
import com.fashionette.pages.LoginPage;
import com.fashionette.pages.Voucher;
import com.fashionette.utilities.BrowserUtilities;
import com.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenerio_03 extends TestBase{

    @Test
    public void scenerio3() throws InterruptedException {

        BasePage basePage = new BasePage();
        LoginPage loginPage = new LoginPage();
        Voucher voucher = new Voucher();

        Thread.sleep(3000);
        BrowserUtilities.acceptCookies();
        BrowserUtilities.waitToBeClickable(basePage.bag);

        basePage.bag.click();
        basePage.valentino.click();
        basePage.basket.click();

        Thread.sleep(2000);
        basePage.buyButton.click();

        Thread.sleep(2000);
        String productPriceInString = voucher.productPrice.getText();
        System.out.println("productPriceInString = " + productPriceInString);

        voucher.voucherLink.click();
        Thread.sleep(2000);
        voucher.voucherCode.sendKeys("qachallenge");
        voucher.voucherCodeSendBtn.click();

        Thread.sleep(1000);
        voucher.discountAmount.getText();
        String discountAmouthInString = voucher.discountAmount.getText();
        System.out.println("discountAmouthInString = " + discountAmouthInString);

        voucher.finalAmount.getText();
        String finalAmouthInString = voucher.finalAmount.getText();
        System.out.println("finalAmouthInString = " + finalAmouthInString);
        System.out.println("converterd value");

        int beforeDiscount  = BrowserUtilities.valueConverter(productPriceInString);
        int discount  = BrowserUtilities.valueConverter(discountAmouthInString);
        int afterDiscount  = BrowserUtilities.valueConverter(finalAmouthInString);

        System.out.println("afterDiscount = " + afterDiscount);
        System.out.println("beforeDiscount = " + beforeDiscount);
        System.out.println("discount = " + discount);
        int expected = beforeDiscount + discount;
        Assert.assertTrue(afterDiscount==expected);


    }
//
//    public static int valueConverter(String numberInWord){
//        numberInWord = numberInWord.substring(0, numberInWord.indexOf(" "));
//        int number = Integer.parseInt(numberInWord);
//        return number;
//    }
}