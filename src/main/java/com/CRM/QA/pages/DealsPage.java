package com.CRM.QA.pages;

import com.CRM.QA.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DealsPage extends TestBase {

    String sheetName="deals";


    @FindBy(xpath ="//td[contains(text(),'CRMPRO')]" )
    WebElement dealsTitle;

    @FindBy(id = "title")
    WebElement dealsTitleInput;

    @FindBy(name="client_lookup")
    WebElement companyName;

    @FindBy(name="contact_lookup")
    WebElement contactLookup;

    @FindBy(name = "close_date")
    WebElement preCloseDate;

    @FindBy(name = "actual_close_date")
    WebElement actualCloseDate;

    @FindBy(xpath = "//input[@type='submit1' and @value='Save1']")
    WebElement saveButton;

    @FindBy(name = "cs_submit")
    WebElement searchButton;

    public DealsPage(){
        PageFactory.initElements(driver, this);
    }
    public  boolean isLabelDisplayed(){
        System.out.println();
        return dealsTitle.isDisplayed();
    }

    public void searchDealByName(String dealName){
        try{
            WebElement dealsTitleInput = driver.findElement(By.name("cs_keyword"));
            dealsTitleInput.sendKeys(dealName);
            searchButton.click();
        }catch (NoSuchElementException e){
            System.out.println("no such elelnt is found"+ e.getMessage());
        }

    }

    public  void createNewDeal(String title,String comp_name,String prim_contact,String pred_close_date,String act_close_date){

        dealsTitleInput.sendKeys(title);
        companyName.sendKeys(comp_name);
        contactLookup.sendKeys(prim_contact);

        // Handle preCloseDate (readonly field) using JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + pred_close_date + "';", preCloseDate);

        // Handle actualCloseDate (readonly field) using JavaScript Executor
        js.executeScript("arguments[0].value='" + act_close_date + "';", actualCloseDate);

        saveButton.click();
    }

}
