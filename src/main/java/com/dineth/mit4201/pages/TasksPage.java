package com.dineth.mit4201.pages;

import com.dineth.mit4201.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TasksPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[1]/input")
    @CacheLookup
    WebElement customerName;

    @FindBy(xpath = "//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/textarea")
    @CacheLookup
    WebElement customerDescription;

    @FindBy(xpath = "//div[@class='components_button withPlusIcon']")
    @CacheLookup
    WebElement createCustomer;

    @FindBy(xpath = "//div[@class='node customerNode editable selected']")
    WebElement newlyCreatedCustomer;

    @FindBy(xpath = "//div[@class='item createNewCustomer']")
    WebElement creatNewCustomerLink;

    @FindBy(xpath = "//div[@class='downIcon']")
    WebElement addNewDropDown;


    public TasksPage() {

        PageFactory.initElements(driver, this);
    }

    public void createNewCustomer(String firstName, String description) {
        addNewDropDown.click();
        creatNewCustomerLink.click();
        int randomNum = 1 + (int) (Math.random() * 5);
        String customerFinalName = firstName.concat(String.valueOf(randomNum));
        customerName.sendKeys(customerFinalName);
        customerDescription.sendKeys(description);
        createCustomer.click();
        Assert.assertTrue(newlyCreatedCustomer.findElement(By.className("text")).getText().equalsIgnoreCase(customerFinalName));
    }

}
