package com.qa.trello.framework;

import com.qa.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
       return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
      //  return wd.findElements(By.xpath("//div[@class='all-boards']//li[1]//a[1]")).size()-1;
    }
    public void goToBoardsPageUrl(String username){

        wd.navigate().to("https://trello.com/"+username+"/boards");
    }

    public void fillBoardForm(Board board) {
        typeBoardName(board.getName());
        selectTeamFromBoardCreationForm(board.getTeam());
        click(By.cssSelector("[title="+board.getColor()+"]"));
    }

    public void typeBoardName(String name) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), name);
    }

    public void selectTeamFromBoardCreationForm(String team) {
       click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        click(By.xpath("//span[contains(text(),'" + team + "')]")); ;
    }

    public void confirmBoardCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"),20);
    }

    public void initBoardCreation() {
        waitForElementLocatedAndClick(By.name("add"),20);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id='header-create-board-button']"),20);
    }

    public void createBoard() {
        initBoardCreation();
        fillBoardForm(new Board()
                .withName("Test")
                .withTeam("No team")
                .withColor("blue"));
        confirmBoardCreation();
        returnToHomePage();
    }

    public void clickMoreButton() {

        waitForElementLocatedAndClick(By.cssSelector(".js-open-more"),20);
    }

    public void confirm() {
        waitForElementLocatedAndClick(By.cssSelector(".js-confirm"),20);
    }

    public void clickCloseBoardFromMoreMenu() {
        waitForElementLocatedAndClick(By.cssSelector(".js-close-board"),20);
    }

    public void initBoardDeletionInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void permanentlyDeleteBoard() {
        waitForElementLocatedAndClick(By.cssSelector(".js-delete"),20);
        confirm();
    }

    public void openFirstPersonalBoard(){
      //  click(By.xpath("//div[@class='all-boards']//div[2]//div[2]//ul[1]//li[1]"));
        waitForElementLocatedAndClick(By.xpath("//div[@class='all-boards']//li[1]//a[1]"),30);
    }

    public void changeName() {

        wd.findElement(By.cssSelector(".js-rename-board")).click();

        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("ggg" + Keys.ENTER);

    }

    public boolean isOnBoardsPage() throws InterruptedException{
        Thread.sleep(3000);
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }
    public void openBoardsPage() {
       waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"),30);
    }

}
