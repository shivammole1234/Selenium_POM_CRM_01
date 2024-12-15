package com.CRM.QA.testcases;

import com.CRM.QA.base.TestBase;
import com.CRM.QA.pages.Homepage;
import com.CRM.QA.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    Homepage homepage;
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initilization();
         loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
       String title= loginPage.validate_login_page_title();
        Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2)
    public void CRMlogoImageTest(){
        Assert.assertTrue(loginPage.validate_CRM_logo_img());
    }

    @Test(priority = 3)
    public void loginTest(){
       homepage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
      //  Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }

}
