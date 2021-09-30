package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.List;

public class HomePage extends TestBase {

    //@FindBy(xpath="//img[contains(@src,'https://www.progressive.com/content/images/domainprogressive/wh3/base/icons/products/blue/AU.svg')]")
    //WebElement clickAuto;

     @FindBy (xpath = "//input[@name='zipCode']")
     WebElement zipcodeTextbox;

    @FindBy (xpath = "//button[text()='Get my price']")
    WebElement getMyPrice;



    public HomePage(){
        PageFactory.initElements(driver,this);
    }

      public  String validateHomePage(){
        return driver.getTitle();
    }

    public BasicFormPage  inputAndClickZipcode(String zipcode){
        zipcodeTextbox.sendKeys(zipcode);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Get my price']")));
        getMyPrice.click();
        return new BasicFormPage();

    }

}

