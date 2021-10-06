package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VehicleInfoPage extends TestBase {

    @FindBy(xpath = "//body/div[@id='app']/div[@id='page-content']/div[@id='interview-container']/div[@id='VI01-0']/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]")
    WebElement yearMakeModel;

    @FindBy(xpath = "//select[@id='year-vehicle-0_selectNode']")
    WebElement selectYear;

    @FindBy(xpath = "//select[@id='make-vehicle-0_selectNode']")
    WebElement make;

    @FindBy(xpath = "//select[@id='model-vehicle-0_selectNode']")
    WebElement model;

    @FindBy(xpath = "//*[@id='fullModelName-vehicle-0_selectNode']")
    WebElement Trim;

    @FindBy(xpath = "//*[@id='bodyStyle-vehicle-0_selectNode']")
    WebElement bodyStyle;

    @FindBy(xpath = "//a[@id='nextButton-0']")
    WebElement saveAndContinue;

    @FindBy(xpath = "//a[@id='backButton-1']")
    WebElement back;

    @FindBy(xpath = "//a[@id='resourceList-vehicles-vehicle-0_addNode']")
    WebElement addAnotherVehicle;

    @FindBy(xpath = "//*[@id='year-vehicle-1_selectNode']")
    WebElement secondvehicleyear;

    @FindBy(xpath = "//*[@id='make-vehicle-1_selectNode']")
    WebElement secondVehicleModel;

    @FindBy(xpath = "//*[@id='vin-vehicle-0']//input")
    WebElement vIN;

    public VehicleInfoPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean  verifyDefaultValue(){
        boolean selection = yearMakeModel.isEnabled();
               return selection;
    }

    public void selectModelYear(){
        Select year= new Select(selectYear);
        year.selectByVisibleText("2018");;
    }

    public void selectMake() {
        Select modelmake = new Select(make);
        modelmake.selectByVisibleText("HONDA");

    }

    public void selectModel() {
        Select modeltype = new Select(model);
        modeltype.selectByVisibleText("ODYSSEY");
    }

    public void selectTrim() {
        Select modeltype = new Select(Trim);
        modeltype.selectByVisibleText("TOURING");
    }

    public String BodyStyle() {
        Select modeltype = new Select(bodyStyle);
        WebElement bs =  modeltype.getFirstSelectedOption();
        String selectedoption = bs.getText();
        return selectedoption;
    }

    public void setAddAnotherVehicle() {
        addAnotherVehicle.click();
    }

    public void setSecondvehicleyear() {
        Select secondVy = new Select(secondvehicleyear);
        secondVy.selectByVisibleText("2007");
    }

   /* public void selectSecondvehicleMake() {
        Select modelmake = new Select(make);
        modelmake.selectByVisibleText("HONDA");*/
}

