package com.CRM.QA.pages;

import com.CRM.QA.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends TestBase {

    String sheetName="contacts";

    @FindBy(xpath="//td[contains(text(),'CRMPRO')]")
    WebElement contactTitle;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="surname")
    WebElement lastName;

    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveButton;

    @FindBy(name = "nickname")
    WebElement nickName;

    @FindBy(name = "client_lookup")
    WebElement clientLookup;

    @FindBy(id="company_position")
    WebElement companyPosition;

    @FindBy(id="department")
    WebElement department_WE;

    @FindBy(name="contact_lookup_sup")
    WebElement contactLookupSup;


    @FindBy(name="contact_lookup_ass")
    WebElement contactLookupAss;


    @FindBy(name="contact_lookup_ref")
    WebElement contactLookupRef;


    @FindBy(name="phone")
    WebElement phone_num;


    @FindBy(name="mobile")
    WebElement mobile_num;


    @FindBy(name="home_phone")
    WebElement home_phone;


    @FindBy(name="fax")
    WebElement fax;


    @FindBy(name="email")
    WebElement email;


    @FindBy(name="email_alt")
    WebElement email_alt;


    @FindBy(name="im_id")
    WebElement im_id;


    @FindBy(name="im_network")
    WebElement im_network;


    @FindBy(name="skype_id")
    WebElement skype_id;

    @FindBy(name="identifier")
    WebElement Identifier;

    // address section element
    @FindBy(name="address_title")
    WebElement address_title;

    @FindBy(id="cb_default_address")
    WebElement cb_default_address;



    public ContactPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isContactLabelDisplayed(){
        System.out.println("Contact label is displayed method running");
        boolean isContactLabelDisplayed = contactTitle.isDisplayed();
        System.out.println("Contact label is displayed: " + isContactLabelDisplayed);
        return contactTitle.isDisplayed();

    }


    public void selectContactsByName(String name) {
        try {
            WebElement checkbox = driver.findElement(By.xpath("//form[@id='vContactsForm']//a[normalize-space(text())='" + name + "']/parent::td/preceding-sibling::td//input[@type='checkbox' and @name='contact_id']"));
            checkbox.click();
        } catch (NoSuchElementException e) {
            System.out.println("Contact not found: " + name);
        }
    }

    public void selectMupltipleContactsByName(){
        driver.findElement(By.xpath("//form[@id='vContactsForm']//a[normalize-space(text())='000Alen 2 000Joe 2']/parent::td/preceding-sibling::td//input[@type='checkbox' and @name='contact_id']"));

    }


    public void createNewcontact
            (String first_Name, String last_Name, String nick_Name, String client_Lookup, String company_Position, String department,
             String contact_LookupSup, String contact_LookupAss, String contact_LookupRef, String phone, String mobile, String home_Phone,
             String FAX, String e_mail, String email_Alt, String im_Id, String im_Network, String skype_Id, String identifier,
             String address_Title,boolean default_Address,String title, String suffix, String category, String status, String source,
             String addType){
        System.out.println("Creating new contact");
        firstName.sendKeys(first_Name);
        lastName.sendKeys(last_Name);
        nickName.sendKeys(nick_Name);
        System.out.println("Nick name is: "+nick_Name);
        clientLookup.sendKeys(client_Lookup);
        companyPosition.sendKeys(company_Position);
        department_WE.sendKeys(department);
        System.out.println("Department is: "+department);
        contactLookupSup.sendKeys(contact_LookupSup);
        contactLookupAss.sendKeys(contact_LookupAss);
        contactLookupRef.sendKeys(contact_LookupRef);
        System.out.println("Contact Lookup Ref is: "+contact_LookupRef);
        home_phone.sendKeys(home_Phone);
        phone_num.sendKeys(phone);
        mobile_num.sendKeys(mobile);
        System.out.println("Mobile number is: "+mobile);
        fax.sendKeys(FAX);
        email_alt.sendKeys(email_Alt);
        System.out.println("Email Alt is: "+email_Alt);
        email.sendKeys(e_mail);
        im_id.sendKeys(im_Id);
        im_network.sendKeys(im_Network);
        System.out.println("IM Network is: "+im_Network);
        skype_id.sendKeys(skype_Id);
        Identifier.sendKeys(identifier);
        address_title.sendKeys(address_Title);
        System.out.println("Address Title is: "+address_Title);

        // check this functionality
        cb_default_address.click();
        if(default_Address){
            cb_default_address.click();
        }

        System.out.println("Default Address is: "+default_Address+"");

        Select select_title=new Select(driver.findElement(By.name("title")));
        select_title.selectByVisibleText(title);


        System.out.println("Title is: "+title);
        Select select_suffix=new Select(driver.findElement(By.name("suffix")));
        select_suffix.selectByVisibleText(suffix);

        Select select_cat=new Select(driver.findElement(By.name("category")));
        select_cat.selectByVisibleText(category);
        System.out.println("Category is: "+category);

        Select select_status=new Select(driver.findElement(By.name("status")));
        select_status.selectByVisibleText(category);

        Select select_source=new Select(driver.findElement(By.name("source")));
        select_source.selectByVisibleText(source);
        System.out.println("Source is: "+source);

        Select address_type=new Select(driver.findElement(By.name("type")));
        address_type.selectByVisibleText(addType);

        Select status_type=new Select(driver.findElement(By.name("status")));
        status_type.selectByVisibleText(status);
        System.out.println("Status is: "+status);
        
        saveButton.click();

    }

    public void create_new_contact_2(String title, String ftName, String ltName, String comp){
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        companyPosition.sendKeys(comp);
        saveButton.click();

    }


}
