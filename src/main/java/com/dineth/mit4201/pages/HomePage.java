package com.dineth.mit4201.pages;

import com.dineth.mit4201.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath = "//a[@class='content tasks']")
    WebElement taskLink;

    @FindBy(xpath = "//a[@class='content reports']")
    WebElement reportsLink;

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actitimeLogo;


    //initialization

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public Boolean validateActiTimeLogo() {
        return actitimeLogo.isDisplayed();
    }


    public TasksPage clickOnTaskLink() {

        taskLink.click();
        return new TasksPage();

    }



}
