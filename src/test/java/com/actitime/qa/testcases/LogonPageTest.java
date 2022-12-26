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

import java.io.IOException;

public class LogonPageTest extends TestBase {

    LoginPage loginPage;
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
    public void loginPageLogoTest() throws IOException {
        boolean flag = loginPage.validateActiTimeLogo();
        TestUtil.takeScreenshotAtEndOfTest("loginPageLogoTest");
        Assert.assertTrue(flag);

    }


    @DataProvider
    public Object[][] getactiTimeTestData() {
        Object data[][] = testUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2, dataProvider = "getactiTimeTestData")
    public void LoginTest(String userName, String password) throws IOException {
        String loggedInUserName = loginPage.loging(userName, password);
        TestUtil.takeScreenshotAtEndOfTest("LoginTest");
        Assert.assertFalse(loggedInUserName.isEmpty());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
