package com.fashionette.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModifyPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Persönliche Daten']")
    public WebElement personliche;

    @FindBy(xpath = "//div[@class='account__content__column account__content__column--customer']//div[@class='account--address__action account--address__action--update'][normalize-space()='Bearbeiten']")
    public WebElement bearbeiten;

    @FindBy(xpath = "//input[@placeholder='Vorname']")
    public WebElement vorname;

    @FindBy(xpath = "//input[@placeholder='Nachname']")
    public WebElement nachname;

    @FindBy(xpath = "//div[contains(@class,'account--address__action account--address__action--save')]")
    public WebElement save;

    @FindBy(xpath = "//div[@class='account--personaldata']//div[2]")
    public WebElement edited;

    @FindBy(xpath = "//*[@zipcode-mask='99999']/div[2]")
    public WebElement editedTitle;


}
