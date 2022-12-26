package com.dineth.mit4201.pages;

import com.dineth.mit4201.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    static Logger log = Logger.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement userName;


    @FindBy(xpath = "//input[@type='password'and @name='pwd']")
    WebElement passWord;

    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name='remember']")
    WebElement keepmeLoggedinCheckBox;

    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;

    @FindBy(xpath = "//a[@class='userProfileLink username ']")
    WebElement loggedInUserNameDisplay;

    public LoginPage() {

        PageFactory.initElements(driver, this);


    }

    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();

    }

    public String loging(String uName, String pword) {

        log.info("Trying to log in using user: {}" + uName);
        userName.sendKeys(uName);
        passWord.sendKeys(pword);
        keepmeLoggedinCheckBox.click();
        loginButton.click();
        return loggedInUserNameDisplay.getText();

    }

    public HomePage logingInitialize(String uName, String pword) {

        log.info("Trying to log in using user: {}" + uName);
        userName.sendKeys(uName);
        passWord.sendKeys(pword);
        keepmeLoggedinCheckBox.click();
        loginButton.click();
//        log.info("Full name of the logged in user: {}" + loggedInUserNameDisplay.getText());
        return new HomePage();

    }
}
