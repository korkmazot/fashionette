package com.fashionette.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChallenge extends TestBase{

    @Test
    public void test1(){

        String title = driver.getTitle();
        Assert.assertEquals(title,"fashionette | Designer Handtaschen, Schuhe, Accessoires & Beauty online kaufen");


    }
}
