package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleInfoPage extends TestBase {




    @FindBy(xpath = "//body/div[@id='app']/div[@id='page-content']/div[@id='interview-container']/div[@id='VI01-0']/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]")
    WebElement yearMakeModel;

    @FindBy(xpath = "//select[@id='year-vehicle-0_selectNode']")
    WebElement selectYear;

    @FindBy(xpath = "//select[@id='make-vehicle-0_selectNode']")
    WebElement make;

    @FindBy(xpath = "//select[@id='model-vehicle-0_selectNode']")
    WebElement model;

    @FindBy(xpath = "//select[@id='fullModelName-vehicle-0_selectNode']")
    WebElement select;

    @FindBy(xpath = "//select[@id='bodyStyle-vehicle-0_selectNode']")
    WebElement Trim;

    @FindBy(xpath = "//a[@id='resourceList-vehicles-vehicle-0_addNode']")
    WebElement bodyStyle;

    @FindBy(xpath = "//a[@id='nextButton-0']")
    WebElement saveAndContinue;

    @FindBy(xpath = "//a[@id='backButton-1']")
    WebElement back;

    @FindBy(xpath = "//a[@id='resourceList-vehicles-vehicle-0_addNode']")
    WebElement addAnotherVehicle;


    @FindBy(xpath = "//*[@id='vin-vehicle-0']//input")
    WebElement vIN;

    public void enterValue(){
    }
}