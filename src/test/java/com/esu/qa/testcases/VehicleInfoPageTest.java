package com.esu.qa.testcases;

import com.esu.qa.base.TestBase;
import com.esu.qa.pages.BasicFormPage;
import com.esu.qa.pages.HomePage;
import com.esu.qa.pages.PersonalInfoEnterPage;
import com.esu.qa.pages.VehicleInfoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehicleInfoPageTest extends TestBase {

        PersonalInfoEnterPage personalInfoEnterPage;
        HomePage homepage;
        BasicFormPage basicFormPage;
        VehicleInfoPage vehicleInfoPage;
        String ZIP_CODE = "95765";
    public VehicleInfoPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        homepage = new HomePage();
        homepage.inputAndClickZipcode(ZIP_CODE);
        basicFormPage = new BasicFormPage();
        personalInfoEnterPage = new PersonalInfoEnterPage();
        vehicleInfoPage = new VehicleInfoPage();




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
        personalInfoEnterPage.populateData("Charles", "darwin", "test@yahoo.com", "26", "1988");


        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        personalInfoEnterPage.SaveAndClick();


    }
    @Test(priority = 1)
    public void verifyDefaultSelection() {
        vehicleInfoPage = new VehicleInfoPage();
        Assert.assertEquals(true, vehicleInfoPage.verifyDefaultValue());

    }

    @Test(priority = 2)
    public void selectYear() {
        vehicleInfoPage.selectModelYear();
    }

    @Test(priority = 3)
    public void selectModelMake() {
        vehicleInfoPage = new VehicleInfoPage();
        vehicleInfoPage.selectModelYear();
        vehicleInfoPage.selectMake();
    }
    @Test(priority = 4)
    public void selectModelDropdown() {
        vehicleInfoPage.selectModelYear();
        vehicleInfoPage.selectMake();
        vehicleInfoPage.selectModel();
    }


    @Test(priority = 5)
    public void selectTrimDropdown() {
        vehicleInfoPage.selectModelYear();
        vehicleInfoPage.selectMake();
        vehicleInfoPage.selectModel();
        vehicleInfoPage.selectTrim();
    }

    @Test(priority = 5)
    public void verifyBodyStyleDefaultDropdown() {
        vehicleInfoPage.selectModelYear();
        vehicleInfoPage.selectMake();
        vehicleInfoPage.selectModel();
        vehicleInfoPage.selectTrim();
        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Assert.assertEquals("Wagon 4 x 2 4 Door", vehicleInfoPage.BodyStyle());
    }

    @Test(priority = 6)
    public void clickAddAnotherVehicle() {
        vehicleInfoPage.selectModelYear();
        vehicleInfoPage.selectMake();
        vehicleInfoPage.selectModel();
        vehicleInfoPage.selectTrim();
        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Assert.assertEquals("Wagon 4 x 2 4 Door", vehicleInfoPage.BodyStyle());
        vehicleInfoPage.setAddAnotherVehicle();
    }

}

