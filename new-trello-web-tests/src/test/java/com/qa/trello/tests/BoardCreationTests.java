package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests<locator> extends TestBase {
    WebDriver wd;

    @BeforeMethod

    public void setUp() {
        wd = new ChromeDriver();
        // wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testBoardCreation() {

        initLogin();
        fillLoginForm("vanyushkinelena@gmail.com", "felia161075");
        confirmLogin();


    }

    public void confirmLogin() {
        clic(By.id("login"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }

    public void initLogin() {
        clic(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text) {
        clic(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clic(By locator) {
        wd.findElement(locator);
    }

  //  @AfterMethod
    public void tearDown() {
          wd.quit();
    }
}

