package com.CRM.QA.pages;

import com.CRM.QA.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage extends TestBase {

    // page factory approcach to initilize the variable
    @FindBy(xpath = "//td[contains(text(),'User: Gagan Khanna')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[normalize-space()='Contacts']")
    WebElement contactsLink;

     @FindBy(xpath = "//a[normalize-space()='Deals']")
    WebElement dealsLink;

     @FindBy(xpath = "//a[normalize-space()='Tasks']")
    WebElement tasksLink;

    //@FindBy(xpath = "//a[contains(text(),'New Contact')]")
    @FindBy(xpath = "//a[@title='New Contact']")
    WebElement newContactsLink;


     public  Homepage(){
         PageFactory.initElements(driver,this);
     }

     public String verifyHomePageTitle(){
         String title = driver.getTitle();
         System.out.println("Title of the page is: "+title);
         return title;
     }

     public ContactPage clickContactsLink(){
         contactsLink.click();
         System.out.println("Clicked on Contacts");
         return new ContactPage();
     }

     public Boolean validateUserNameDisplay(){
         System.out.println("User name is displayed & it is : "+userNameLabel.getText());
         return userNameLabel.isDisplayed();
     }

     public DealsPage clickDealsLink(){
         System.out.println("Clicked on Deals");
         dealsLink.click();
         return new DealsPage();
     }

     public TaskPage clickTasksLink(){
         System.out.println("Clicked on Tasks");
         tasksLink.click();
         return new TaskPage();
     }

    public void clickOnNewContactLink_old() {
        // Hover over the link using Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(newContactsLink).build().perform();

        // Wait for the "New Contact" link to appear or become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newContactElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='New Contact' and text()='New Contact']")));

        // Ensure it's the correct element and then click
        if (newContactElement.isDisplayed() && newContactElement.isEnabled()) {
            newContactElement.click();
            System.out.println("Clicked on New Contacts");
        } else {
            System.out.println("Element not clickable.");
        }
    }

    public void clickOnNewContactLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"a[title='Contacts']\").dispatchEvent(new Event('mouseover'))");

        // WebElement newContactLink = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
        js.executeScript("arguments[0].click();", newContactsLink);

//        Actions action = new Actions(driver);
//        action.moveToElement(contactsLink).build().perform();
//        newcontactLink.click();

    }
    public void clickOnNewContactLink1() {
        // Hover over the link using Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(newContactsLink).build().perform();

        // Wait for the "New Contact" link to become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newContactElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'New Contact')]")));

        // Use JavaScript to click if necessary
        if (newContactElement.isDisplayed() && newContactElement.isEnabled()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newContactElement);
            System.out.println("Clicked on New Contacts using JavaScript");
        } else {
            System.out.println("Element not clickable.");
        }
    }



}
