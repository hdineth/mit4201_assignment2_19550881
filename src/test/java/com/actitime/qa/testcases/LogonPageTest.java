package com.actitime.qa.testcases;

import com.dineth.mit4201.base.TestBase;
import com.dineth.mit4201.pages.HomePage;
import com.dineth.mit4201.pages.LoginPage;
import com.dineth.mit4201.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogonPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    String sheetName = "Users";
    TestUtil testUtil;


    public LogonPageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();

    }


    @Test(priority = 1)
    public void loginPageLogoTest() {
        boolean flag = loginPage.validateActiTimeLogo();
        Assert.assertTrue(flag);

    }


    @DataProvider
    public Object[][] getactiTimeTestData() {
        Object data[][] = testUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2, dataProvider = "getactiTimeTestData")
    public void LoginTest(String userName, String password) {
        homePage = loginPage.loging(userName, password);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}