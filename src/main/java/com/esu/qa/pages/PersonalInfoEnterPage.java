package com.esu.qa.pages;

import com.esu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoEnterPage extends TestBase {
    @FindBy(xpath = "//*[@id='firstName-customer-0']//input[@name='firstName']")
    WebElement firstNameTextBox;

    @FindBy(xpath = "//*[@id=lastName-customer-0]//input[@name='lastName']")
    WebElement lastNameTextBox;


}
