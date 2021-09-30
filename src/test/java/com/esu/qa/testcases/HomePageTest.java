package com.esu.qa.testcases;

import com.esu.qa.base.TestBase;
import com.esu.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {
    HomePage homepage;
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialisation();
        homepage = new HomePage();
    }

    @Test(priority = 1)
    public void validateTitle(){
        String homeTitle = homepage.validateHomePage();
        Assert.assertEquals(homeTitle,"Liberty Mutual | Customize your insurance coverage and get a quote | Liberty Mutual");
    }

    @Test(priority = 2)
    public void clickGetQuote(){
        homepage.inputAndClickZipcode("95765");
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(500);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        driver.quit();
    }
}
