package com.CRM.QA.base;

import com.CRM.QA.utils.TestUtils;
import com.CRM.QA.utils.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringDecorator e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try{
            prop=new Properties();
            FileInputStream ip=new FileInputStream("C:\\Users\\shiv\\java_workspace\\Selenium\\POM_project_CRM\\src\\main\\java\\com\\CRM\\QA\\config\\config.properties");
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //setting up
    public static  void initilization(){
        String browserName=prop.getProperty("browser");
        try{
            if(browserName.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }}catch (Exception e) {
            e.printStackTrace();
        }

        // Create WebDriverListener instance
        WebEventListener eventListener = new WebEventListener();

        // Decorate WebDriver with EventFiringDecorator
        driver = new EventFiringDecorator(eventListener).decorate(driver);


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_timeout,java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait,java.util.concurrent.TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
