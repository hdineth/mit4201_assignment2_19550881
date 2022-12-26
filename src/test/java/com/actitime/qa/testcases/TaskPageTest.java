package com.actitime.qa.testcases;

import com.dineth.mit4201.base.TestBase;
import com.dineth.mit4201.pages.HomePage;
import com.dineth.mit4201.pages.LoginPage;
import com.dineth.mit4201.pages.TasksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 2)
    public void createNewCustomerTest() {
        TasksPage tasksPage = homePage.clickOnTaskLink();
        tasksPage.createNewCustomer("Dineth", "Automation 123");
    }

}
