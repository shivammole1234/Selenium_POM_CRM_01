package com.CRM.QA.testcases;

import com.CRM.QA.base.TestBase;
import com.CRM.QA.pages.*;
import com.CRM.QA.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    Homepage homepage;
    DealsPage dealsPage;
    ContactPage contactPage=new ContactPage();
    TaskPage taskPage=new TaskPage() ;
    LoginPage loginPage;
    TestUtils testUtils = new TestUtils();
    public HomePageTest() {
        super();
    }

    // to do ligin in applicatiojn this method lounch the browser and do login
    @BeforeMethod
    public void setUp(){
        initilization();
        testUtils=new TestUtils();
        loginPage = new LoginPage();
        homepage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void homePageTitleTest(){
       Assert.assertEquals(homepage.verifyHomePageTitle(),"CRMPRO","home page title not matching");
    }

    @Test(priority = 2)
    public void validateUserNameDisplayTest(){
        testUtils.switchToFrame("mainpanel");
       Assert.assertTrue(homepage.validateUserNameDisplay(),"User name not displayed");
    }

    @Test(priority = 3)
    public void clickContactPageTest()
    {
        testUtils.switchToFrame("mainpanel");
        contactPage=homepage.clickContactsLink();

    }
    @Test(priority = 4)
    public void clickDealsPageTest(){
        testUtils.switchToFrame("mainpanel");
        dealsPage=homepage.clickDealsLink();
    }


    @Test(priority = 5)
    public void clickTaskPageTest(){
        testUtils.switchToFrame("mainpanel");
        taskPage=homepage.clickTasksLink();
    }


    @AfterMethod
    public void tesrDown(){
       // driver.quit();
    }

}






















