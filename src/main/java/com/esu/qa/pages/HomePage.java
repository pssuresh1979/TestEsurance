package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath="//img[contains(@src,'https://www.progressive.com/content/images/domainprogressive/wh3/base/icons/products/blue/AU.svg')]")
    WebElement clickAuto;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public  void clickAutoLink(){
        clickAuto.click();
    }

    public  String validateHomePage(){
        return driver.getTitle();
    }

}

