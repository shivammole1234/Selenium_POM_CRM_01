package com.CRM.QA.utils;

import com.CRM.QA.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class WebEventListener extends TestBase implements WebDriverListener {
    public WebEventListener() {
    }

    @Override
    public void beforeGetPageSource(WebDriver driver) {
        WebDriverListener.super.beforeGetPageSource(driver);
    }

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        System.out.println("Before any call to method: " + method.getName() + " on target: " + target);
        WebDriverListener.super.beforeAnyCall(target, method, args);
    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        System.out.println("After any call to method: " + method.getName() + " on target: " + target + " with result: " + result);
        WebDriverListener.super.afterAnyCall(target, method, args, result);
    }



    @Override
    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
        System.out.println("Before WebDriver call: " + method.getName() + " with arguments: " + java.util.Arrays.toString(args));
        WebDriverListener.super.beforeAnyWebDriverCall(driver, method, args);
    }

    @Override
    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
        System.out.println("After WebDriver call: " + method.getName() + " with result: " + result);
        WebDriverListener.super.afterAnyWebDriverCall(driver, method, args, result);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Before navigating to URL: " + url);
        WebDriverListener.super.beforeGet(driver, url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("After navigating to URL: " + url);
        WebDriverListener.super.afterGet(driver, url);
    }

    @Override
    public void beforeGetCurrentUrl(WebDriver driver) {
        System.out.println("Before getting the current URL.");
        WebDriverListener.super.beforeGetCurrentUrl(driver);
    }

    @Override
    public void afterGetCurrentUrl(WebDriver driver, String result) {
        System.out.println("After getting the current URL: " + result);
        WebDriverListener.super.afterGetCurrentUrl(driver, result);
    }

    @Override
    public void beforeGetTitle(WebDriver driver) {
        System.out.println("Before getting the page title.");
        WebDriverListener.super.beforeGetTitle(driver);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        System.out.println("After getting the page title: " + result);
        WebDriverListener.super.afterGetTitle(driver, result);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Before finding element with locator: " + locator);
        WebDriverListener.super.beforeFindElement(driver, locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("After finding element with locator: " + locator + ", Element: " + result);
        WebDriverListener.super.afterFindElement(driver, locator, result);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        System.out.println("Before finding elements with locator: " + locator);
        WebDriverListener.super.beforeFindElements(driver, locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println("After finding elements with locator: " + locator + ", Elements found: " + result.size());
        WebDriverListener.super.afterFindElements(driver, locator, result);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("Error in method: " + method.getName() + " on target: " + target + " with exception: " + e.getCause());
        try {
            TestUtils.takeScreenshotAtEndOfTest();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        WebDriverListener.super.onError(target, method, args, e);
    }

//    public void onError(Throwable error, WebDriver driver) {
//        System.out.println("Exception occured: " + error);
//        try {
//            TestUtils.takeScreenshotAtEndOfTest();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
