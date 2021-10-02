package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfoEnterPage extends TestBase {
    @FindBy(xpath = "//input[@type='text' and @name='firstName']")
    WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@type='text'and @name='lastName']")
    WebElement lastNameTextBox;

    @FindBy(xpath = "//*[@id='dateOfBirth-customer-0']//select[@aria-label='month']")
    WebElement dateOfBirthMonth;

    @FindBy(xpath = "//input[@name='day']")
    WebElement dateOfBirthDate;

    @FindBy(xpath = "//input[@name='year']")
    WebElement dateOfBirthYear;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailAddress;

    @FindBy(xpath = " //a[@ class = 'btn btn-lrg']")
    WebElement backButton;

    @FindBy(xpath = " //a[@class='btn btn-primary btn-lrg']")
    WebElement saveAndContinue;

    public PersonalInfoEnterPage(){
        PageFactory.initElements(driver,this);
    }

    public void populateData(String firstname ,String Lastname , String EmailAddress,String date,String year ){
        firstNameTextBox.sendKeys(firstname);
        lastNameTextBox.sendKeys(Lastname);
        emailAddress.sendKeys(EmailAddress );
        Select month = new Select(dateOfBirthMonth);
        month.selectByVisibleText("August");
        dateOfBirthDate.sendKeys(date);
        dateOfBirthYear.sendKeys(year);

    }

    public void SaveAndClick(){
        saveAndContinue.click();
    }
}