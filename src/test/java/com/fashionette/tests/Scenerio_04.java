package com.fashionette.tests;

import com.fashionette.pages.BasePage;
import com.fashionette.utilities.BrowserUtilities;
import com.fashionette.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenerio_04 extends  TestBase{

    BasePage basePage = new BasePage();

    @Test
    public void scenerio3() throws InterruptedException {


        String title = driver.getTitle();
        Assert.assertEquals(title, "fashionette | Designer Handtaschen, Schuhe, Accessoires & Beauty online kaufen");
        Thread.sleep(5000);


        BrowserUtilities.acceptCookies();
        BrowserUtilities.waitToBeClickable(basePage.bag);

        basePage.bag.click();
        basePage.valentino.click();
        basePage.basket.click();

        Thread.sleep(2000);
        basePage.buyButton.click();
      //  System.out.println("heeloo");

        Thread.sleep(2000);
        WebElement productPrice = Driver.get().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[2]/td"));
        String productPriceInString = productPrice.getText();
        System.out.println("productPriceInString = " + productPriceInString);



        Thread.sleep(1000);

        //voucher link ine kilikle
        Driver.get().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[3]/td/a")).click();
        Thread.sleep(1000);
        //voucher i gir
        Driver.get().findElement(By.xpath("//*[@name=\"voucherCode\"]")).sendKeys("qachallenge");


        //submit the voucler to apply
        Driver.get().findElement(By.xpath("//button[@type=\"submit\"]")).click();

        Thread.sleep(2000);
        WebElement discountAmouth = Driver.get().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[3]/td/span"));
        String discountAmouthInString = discountAmouth.getText();
        System.out.println("discountAmouthInString = " + discountAmouthInString);


        WebElement finalAmouth = Driver.get().findElement(By.xpath("//*[@id=\"cart__total\"]"));
        String finalAmouthInString = finalAmouth.getText();
        System.out.println("finalAmouthInString = " + finalAmouthInString);

        System.out.println("converterd value");




        int beforeDiscount  = valueConverter(productPriceInString);
        int discount  = valueConverter(discountAmouthInString);
        int afterDiscount  = valueConverter(finalAmouthInString);

        System.out.println("afterDiscount = " + afterDiscount);
        System.out.println("beforeDiscount = " + beforeDiscount);
        System.out.println("discount = " + discount);
        int expected = beforeDiscount + discount;


        Assert.assertTrue(afterDiscount==expected);

    }

    public static int valueConverter(String numberInWord){
        numberInWord = numberInWord.substring(0, numberInWord.indexOf(" "));
        int number = Integer.parseInt(numberInWord);
        return number;
    }

}
