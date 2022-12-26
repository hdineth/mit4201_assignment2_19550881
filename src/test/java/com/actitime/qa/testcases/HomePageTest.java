package com.actitime.qa.testcases;

import com.dineth.mit4201.base.TestBase;
import com.dineth.mit4201.pages.HomePage;
import com.dineth.mit4201.pages.LoginPage;
import com.dineth.mit4201.pages.TasksPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
    }


    @Test(priority = 1)
    public void homePageLogoTest() {
        boolean flag = homePage.validateActiTimeLogo();
        Assert.assertTrue(flag, "Cannot find the Logo");

    }


    @Test(priority = 2)
    public void homePageTaskLinkTest() {
        TasksPage tasksPage = homePage.clickOnTaskLink();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
