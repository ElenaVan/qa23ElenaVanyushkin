package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod

    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        login("vanyushkinelena@gmail.com", "felia161075");
    }


    public int getBoardsCount() {
       return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
      //  return wd.findElements(By.xpath("//div[@class='all-boards']//li[1]//a[1]")).size()-1;
    }

    public void returnToHomePage() {
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
    }

    public void fillBoardForm(String nameOfBoard, String colorOfBoard) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        click(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"));
        click(By.cssSelector(colorOfBoard));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    public void initBoardCreation() {
        click(By.name("add"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

      @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void createBoard() {
        initBoardCreation();
        fillBoardForm("Test", "[title='blue']");
        confirmBoardCreation();
        returnToHomePage();
    }

    public void clickMoreButton() {

        click(By.cssSelector(".js-open-more"));
    }
    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }
    public void clickCloseBoardFromMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }
    public void initBoardDeletionInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }
    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void login(String email, String password) {
        initLogin();
        fillLoginForm(email, password);
        confirmLogin();
    }

    public void openFirstPersonalBoard(){
      //  click(By.xpath("//div[@class='all-boards']//div[2]//div[2]//ul[1]//li[1]"));
        click(By.xpath("//div[@class='all-boards']//li[1]//a[1]"));
    }

    public void fillForm(String nameOfTeam, By locatorTeamType) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(locatorTeamType);
    }

    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
    }

    public void initTeamCreation() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
    }

        public boolean isElementPresent(By locator) {
            return wd.findElements(locator).size() > 0;
        }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }
    public void openTeamSettings() {
        openFirstTeam();
        openSettings();
    }

    public void openSettings() {
    }

    public void openFirstTeam() {
    }


}