package com.esu.qa.testcases;

import com.esu.qa.base.TestBase;
import com.esu.qa.pages.BasicFormPage;
import com.esu.qa.pages.HomePage;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import javax.swing.*;

public class BasicFormPageTest extends TestBase {
    HomePage homepage;
    BasicFormPage basicFormPage;
    String ZIP_CODE = "95765";


    public BasicFormPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        homepage = new HomePage();
        homepage.inputAndClickZipcode(ZIP_CODE);
        basicFormPage = new BasicFormPage();
        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Test(priority = 1)
    public void verifyZipCode() {
        Assert.assertEquals(ZIP_CODE, basicFormPage.verifyZip());
    }

    @Test(priority = 2)
    public void verifyCity() {
        Assert.assertEquals("Rocklin", basicFormPage.verifyCity());
    }

    @Test(priority = 3)
    public void verifyStateLabel() {
        Assert.assertEquals("CA", basicFormPage.verifyStateLabel());
    }

    @Test(priority = 4)
    public void doPopulateAddress() {
        basicFormPage.populateAddress("6703 Denali ct", "1105");
    }

    @Test(priority = 5)
    public void verifyPriorAddressDetails() {
        basicFormPage.setPriorAddressToNo();
        basicFormPage.populatePriorAddress("45 rio linda drive", "8909", "95747", "Folsom");
        basicFormPage.clickSaveAndContinue();
        String errorToBeCompared = "Please correct 2 error(s) on this page before continuing.";
        Assert.assertEquals(errorToBeCompared, basicFormPage.sendLabelErrorForNotFilledFutureAddress());
        try {
            Thread.sleep(3000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
        @Test(priority = 6)
        public void clickAndSave(){
            basicFormPage.setPriorAddressToNo();
            basicFormPage.populateAddress("6703 denali ct", "1105");
            basicFormPage.populatePriorAddress("45 rio linda drive", "8909", "95747", "Folsom");
            basicFormPage.clickSaveAndContinue();

            try {
                Thread.sleep(500);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }


        @AfterMethod
        public void tearDown () {
            try {
                Thread.sleep(2000);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            driver.quit();
        }
    }


