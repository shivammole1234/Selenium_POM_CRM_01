package com.CRM.QA.testcases;

import com.CRM.QA.base.TestBase;
import com.CRM.QA.pages.ContactPage;
import com.CRM.QA.pages.Homepage;
import com.CRM.QA.pages.LoginPage;
import com.CRM.QA.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    Homepage homePage;
    ContactPage contactPage;
    TestUtils testUtils;
    String sheetName = "contact_data_CRM";

    public ContactPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initilization();
        contactPage = new ContactPage();
        loginPage = new LoginPage();
        testUtils=new TestUtils();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtils.switchToFrame("mainpanel");
        contactPage=homePage.clickContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactPageLabelTest(){
        Assert.assertTrue(contactPage.isContactLabelDisplayed(),"Contact label is not displayed");
    }

    @Test(priority = 2)
    public void selectContactByNameTest(){
        contactPage.selectContactsByName("000000Jagadish AutomationFramework");
    }

    @Test(priority = 3)
    public void selectMultipleContactTest(){
        contactPage.selectMupltipleContactsByName();
    }

//    @Test
//    public void createNewContactTest(){
//        homePage.clickOnNewContactLink();
//        contactPage.createNewcontact(
//                "Ravi",               // first_Name
//                "Kumar",              // last_Name
//                "RaviK",              // nick_Name
//                "C12345",             // client_Lookup
//                "Manager",            // company_Position
//                "IT",                 // department
//                "Sup123",             // contact_LookupSup
//                "Ass123",             // contact_LookupAss
//                "Ref123",             // contact_LookupRef
//                "9876543210",         // phone
//                "9876543210",         // mobile
//                "02212345678",        // home_Phone
//                "02287654321",        // FAX
//                "ravi.kumar@example.com",  // e_mail
//                "ravi.alt@example.com",    // email_Alt
//                "ravi_im",            // im_Id
//                "Google",             // im_Network
//                "ravi_skype",         // skype_Id
//                "IND12345",           // identifier
//                "Permanent",          // address_Title
//                true,                 // default_Address (true to select the checkbox)
//                "Mr.",                // title
//                "Jr.",                // suffix
//                "Employee",           // category
//                "Active",             // status
//                "Referral",           // source
//                "Home"                // addType (address type)
//        );
//    }

    @DataProvider
    public  Object[][] getCRMTestData(){
        Object[][] data = TestUtils.getTestData(sheetName);
                return data;
    }

    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void createNewContactTest22(String title,String firstName, String lastName,String company){
        homePage.clickOnNewContactLink();
        //contactPage.create_new_contact_2("Mr.", "Tom", "Peter", "Google");
        contactPage.create_new_contact_2(title,firstName,lastName,company);
    }


    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}

