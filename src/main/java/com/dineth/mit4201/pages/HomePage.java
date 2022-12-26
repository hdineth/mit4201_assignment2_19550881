package com.dineth.mit4201.pages;

import com.dineth.mit4201.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    static Logger log = Logger.getLogger(HomePage.class.getName());


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
        log.info("Logo size: {}" + actitimeLogo.getSize());
        return actitimeLogo.isDisplayed();
    }


    public TasksPage clickOnTaskLink() {
        log.info("clicking task link located at: {}" + taskLink);
        taskLink.click();
        return new TasksPage();

    }


}
