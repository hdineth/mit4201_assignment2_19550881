package com.actitime.qa.testcases;

import com.dineth.mit4201.base.TestBase;
import com.dineth.mit4201.pages.HomePage;
import com.dineth.mit4201.pages.LoginPage;
import com.dineth.mit4201.pages.TasksPage;
import com.dineth.mit4201.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TaskPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.logingInitialize(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 2)
    public void createNewCustomerTest() throws IOException {
        TasksPage tasksPage = homePage.clickOnTaskLink();
        Map<String, String> customerNameMap = tasksPage.createNewCustomer("Dineth", "Automation 123");
        TestUtil.takeScreenshotAtEndOfTest("createNewCustomerTest");
        Assert.assertEquals(customerNameMap.get("divText"),customerNameMap.get("customerFinalName"));
    }

}
