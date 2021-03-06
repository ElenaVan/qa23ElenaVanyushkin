package com.qa.trello.tests;

import com.qa.trello.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite

    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
logger.info("Start test"+ m.getName()+"with parameters: "+ Arrays.asList(p));
    }
    @AfterMethod
    public void lodTestStop(Method m){
        logger.info("Stop test"+ m.getName());
    }


    @AfterSuite
    public void tearDown() {
          app.stop();
      }


}