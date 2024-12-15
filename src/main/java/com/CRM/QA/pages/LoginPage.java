package com.CRM.QA.pages;

import com.CRM.QA.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    // page factory object repo

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUpLink;

    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement logo;

    // initilizing the page object by constructur
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public String validate_login_page_title(){
        return driver.getTitle();
    }

    public boolean validate_CRM_logo_img(){
        return logo.isDisplayed();
    }

    // method to validate login functionality
    public Homepage login(String usrname,String pass){
        username.sendKeys(usrname);
        password.sendKeys(pass);
        loginButton.click();
        System.out.println("Logged in successfully");
        return new Homepage();
    }
}
