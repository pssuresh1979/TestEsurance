package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class BasicFormPage extends TestBase {
    @FindBy(xpath = "//input[@name='address']")
    WebElement streetName;

    @FindBy(xpath = "//label[@id='additionalStreetAddress-customer-0']//input[@type='text' and @aria-label='Apt/Unit #']")
    WebElement aptNumber;

    @FindBy(xpath = "//*[@id='zipCode-customer-0']//input[@name='postalCode']")
    WebElement zipCode;

    @FindBy(xpath = "//*[@name='city']")
    WebElement city;

    @FindBy(xpath = "//*[@id='state-customer-0']//span[@class='read-only']")
    WebElement stateLabel;

    @FindBy(xpath = "//input[@id='priorResidenceAddressIndicator-customer-0-N']")
    WebElement sameCityNo;

    @FindBy(xpath = "//input[@id='priorResidenceAddressIndicator-customer-0-Y']")
    WebElement sameCityYes;

    @FindBy(xpath = "//*[@id='priorResidenceStreetAddress-customer-0']//input[@type='text']")
    WebElement priorStreetName;

    @FindBy(xpath = "//*[@id='priorResidenceAdditionalStreetAddress-customer-0']//input[@type='text']")
    WebElement priorAptNumber;

    @FindBy(xpath = "//*[@id='priorResidenceZipCode-customer-0']//input[@type='text']")
    WebElement priorZipCode;

    @FindBy(xpath = "//*[@id='priorResidenceCity-customer-0']//input[@type='text']")
    WebElement priorCity;

    @FindBy(xpath = "//*[@id='nextButton-0']")
    WebElement saveAndContinue;

    @FindBy(xpath = "//div[@aria-label='Error']//p/strong")
    WebElement pleaseCorrect;


    public BasicFormPage(){
        PageFactory.initElements(driver,this);
    }


    public void populateAddress(String strStreetName, String strAptNumber){
        streetName.sendKeys(strStreetName);
        aptNumber.sendKeys(strAptNumber);
    }

    public String verifyCity(){
        String strCity = city.getText();
        return city.getAttribute("value");
    }

    public String verifyZip() {
        return zipCode.getAttribute("value");
    }

    public String verifyStateLabel(){
        return stateLabel.getText();
    }

    public void setPriorAddressToNo(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", sameCityNo);
    }

    public void verifyPriorAddressIsYes() {
        sameCityYes.isEnabled();
    }

    public void populatePriorAddress(String strPriorStreetName, String strPriorAptNumber,String strPriorZipCode, String strPriorCity) {
        try {
            Thread.sleep(1000);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        priorStreetName.sendKeys(strPriorStreetName);
        priorAptNumber.sendKeys(strPriorAptNumber);
        priorZipCode.sendKeys(strPriorZipCode);
        priorCity.sendKeys(strPriorCity);
    }

    public String sendLabelErrorForNotFilledFutureAddress() {
        String text = pleaseCorrect.getText();
        return text;
    }

     public void clickSaveAndContinue(){
         //WebDriverWait wait = new WebDriverWait(driver,30);
         //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nextButton-0']")));
         try {
             Thread.sleep(2000);
         } catch (Exception exception) {
             exception.printStackTrace();
         }
         saveAndContinue.click();

     }
}