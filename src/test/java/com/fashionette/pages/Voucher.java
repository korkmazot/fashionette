package com.fashionette.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Voucher extends BasePage{


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[2]/td")
    public WebElement productPrice;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[3]/td/a")
    public WebElement voucherLink;

    //cart__sum__voucher-link

//    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[3]/td/a")
//    public WebElement voucherLink;

    @FindBy(xpath = "//*[@name='voucherCode']")
    public WebElement voucherCode;

     ///html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[3]/td/a
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement voucherCodeSendBtn;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/table/tbody/tr[3]/td/span")
    public WebElement discountAmount;

    @FindBy(xpath = "//class")
    public WebElement finalAmount;

}
