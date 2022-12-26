package com.actitime.qa.testcases;

import com.dineth.mit4201.base.TestBase;
import com.dineth.mit4201.pages.HomePage;
import com.dineth.mit4201.pages.LoginPage;
import com.dineth.mit4201.pages.TasksPage;
import com.dineth.mit4201.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

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
        homePage = loginPage.logingInitialize(properties.getProperty("username"), properties.getProperty("password"));
    }


    @Test(priority = 1)
    public void homePageLogoTest() throws IOException {
        boolean flag = homePage.validateActiTimeLogo();
        TestUtil.takeScreenshotAtEndOfTest("homePageLogoTest");
        Assert.assertTrue(flag, "Cannot find the Logo");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
