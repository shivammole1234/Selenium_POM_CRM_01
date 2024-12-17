package com.CRM.QA.testcases;

import com.CRM.QA.base.TestBase;
import com.CRM.QA.pages.DealsPage;
import com.CRM.QA.pages.Homepage;
import com.CRM.QA.pages.LoginPage;
import com.CRM.QA.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DealsPageTest extends TestBase {
    LoginPage loginPage;
    Homepage homepage;
    DealsPage dealsPage;
    TestUtils testUtils;
    String sheetName = "Deals";


    public DealsPageTest(){
        super();
    }

    @BeforeMethod
    public void  setUp(){
        initilization();
        loginPage=new LoginPage();
        homepage=new Homepage();
        dealsPage=new DealsPage();
        testUtils=new TestUtils();
        homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtils.switchToFrame("mainpanel");
        dealsPage=homepage.clickDealsLink();
    }

    @Test
    public void verifyDelaPageTitleTest(){
        Assert.assertTrue(dealsPage.isLabelDisplayed());
    }

    @Test
    public void searchDealByNameTest(){
        dealsPage.searchDealByName("Test");
    }

    @Test
    public void createNewDeal(){
        homepage.clickOnNewDealsLink();
        dealsPage.createNewDeal("New deal by cognizent", "ABC Corp", "John Doe", "2024-12-20", "2024-12-25");
    }

    @DataProvider
    Object[][] getCRMTestDealData(){
        Object[][] data = TestUtils.getDealDataTest(sheetName);
        return data;
    }

    @Test(dataProvider = "getCRMTestDealData")
    public void createNewDeal2(String title, String comp_name, String prim_contact,
                               String pred_close_date, String act_close_date){
        homepage.clickOnNewDealsLink();
        dealsPage.createNewDeal( title, comp_name, prim_contact, pred_close_date, act_close_date );
    }

}
