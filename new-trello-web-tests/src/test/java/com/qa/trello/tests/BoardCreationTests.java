package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
    WebDriver wd;

    @BeforeMethod

    public void setUp() {
        wd = new ChromeDriver();
       wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testBoardCreation() {


     int before = getBoardsCount();
        initLogin();
        fillLoginForm("vanyushkinelena@gmail.com", "felia161075");
        confirmLogin();
        initBoardCreation();
        fillBoardForm("Test", "[title='blue']");
        confirmBoardCreation();
        returnToHomePage();
        int after = getBoardsCount();
       // Assert.assertEquals(after, before +1);


    }
    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;}

    public void returnToHomePage() {
        clic(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
        clic(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
    }

    public void fillBoardForm(String nameOfBoard, String colorOfBoard) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
        clic(By.cssSelector("button.W6rMLOx8U0MrPx"));
        clic(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"));
        clic(By.cssSelector(colorOfBoard));
    }

    public void confirmBoardCreation() {
        clic(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    public void initBoardCreation() {
        clic(By.name("add"));
        clic(By.cssSelector("[data-test-id='header-create-board-button']"));
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
        wd.findElement(locator).click();
    }

  //  @AfterMethod
    public void tearDown() {
          wd.quit();
    }
}

