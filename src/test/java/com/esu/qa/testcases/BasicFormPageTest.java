package com.esu.qa.testcases;

import com.esu.qa.base.TestBase;
import com.esu.qa.pages.BasicFormPage;
import com.esu.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicFormPageTest extends TestBase {
    HomePage homepage;
    BasicFormPage basicFormPage;
    String ZIP_CODE  = "95765";

    public BasicFormPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialisation();
        homepage = new HomePage();
        homepage.inputAndClickZipcode(ZIP_CODE);
        basicFormPage = new BasicFormPage();
        try {
                Thread.sleep(5000);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }

    @Test(priority = 1)
    public void verifyZipCode(){
        Assert.assertEquals(ZIP_CODE,basicFormPage.verifyZip());
    }

    @Test(priority = 2)
    public void verifyCity(){
         Assert.assertEquals("Rocklin", basicFormPage.verifyCity());
    }

    @Test(priority = 3)
    public void verifyStateLabel(){
       Assert.assertEquals("CA", basicFormPage.verifyStateLabel());
    }

    @Test(priority = 4)
    public void doPopulateAddress(){
        basicFormPage.populateAddress("6703 Denali ct","1105");
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
