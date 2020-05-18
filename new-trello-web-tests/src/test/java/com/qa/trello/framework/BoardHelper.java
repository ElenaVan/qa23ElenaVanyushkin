package com.qa.trello.framework;

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

    public void openFirstPersonalBoard(){
      //  click(By.xpath("//div[@class='all-boards']//div[2]//div[2]//ul[1]//li[1]"));
        click(By.xpath("//div[@class='all-boards']//li[1]//a[1]"));
    }

    public void changeName() {

        wd.findElement(By.cssSelector(".js-rename-board")).click();

        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("ggg" + Keys.ENTER);

    }

    public boolean isOnBoardsPage(){
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }
    public void openBoardsPage() {
       click(By.cssSelector("[href$=boards]"));
    }

}
