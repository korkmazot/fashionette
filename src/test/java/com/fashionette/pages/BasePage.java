package com.fashionette.pages;

//import...

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    //public BasePage(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div[3]/div[1]/a")
    public WebElement bag;




}
