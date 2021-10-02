package com.esu.qa.testcases;

import com.esu.qa.base.TestBase;
import com.esu.qa.pages.BasicFormPage;
import com.esu.qa.pages.HomePage;
import com.esu.qa.pages.PersonalInfoEnterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoEnterPageTest extends TestBase {
    PersonalInfoEnterPage personalInfoEnterPage;
    HomePage homepage;
    BasicFormPage basicFormPage;
    String ZIP_CODE = "95765";


    public PersonalInfoEnterPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        homepage = new HomePage();
        homepage.inputAndClickZipcode(ZIP_CODE);
        basicFormPage = new BasicFormPage();
        personalInfoEnterPage = new PersonalInfoEnterPage();

        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        basicFormPage.populateAddress("6703 denali ct", "1105");
        basicFormPage.clickSaveAndContinue();

        try {
            Thread.sleep(500);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Test(priority = 1)
    public void populatePersonalInfo() {
        personalInfoEnterPage.populateData("Charles","darwin","test@yahoo.com","26","1988");

        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    @Test(priority = 2)
    public void SaveAndContinue() {
        personalInfoEnterPage.populateData("Charles", "darwin", "test@yahoo.com", "26", "1988");


        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        personalInfoEnterPage.SaveAndClick();

    }

}
