package com.qa.trello.framework;

import org.openqa.selenium.By;

public class BoardHelper  extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }



    public void confirmBoardCreation() {
        click(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    public void fillBoardForm(Board board) {
        typeBoardName(board.getName());
        selectTeamFromBoardCreationForm(board.getTeam());
        click(By.cssSelector("[title='"+board.getColor()+"']"));//board.getColor()));
    }
    private void typeBoardName(String nameOfBoard) {

        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
    }

    private void selectTeamFromBoardCreationForm(String team) {
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        click(By.xpath("//span[contains(text(), '" + team + "')]"));
    }


    public void initBoardCreation() {
        click(name("add"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void permanentlyDeletBoard() {
        click(cssSelector(".js-delete"));
        confirm();
    }

    public void initBoardDeletionInBoardMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();

    }

    public void clickCloseBoardFromMoreMenu() {
        click(cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {

            WebElement moreButton = new WebDriverWait(wd, 30)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-open-more")));
            if(!moreButton.isDisplayed()) {
                wd.findElement(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar")).click();
            }
            click(By.cssSelector(".js-open-more"));
        }


    public void openFirstPersonalBoard() {
        click(xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void createBoard() {
        initBoardCreation();
        fillBoardForm(new Board()
                .withName("Test")
                .withTeam("No team"));

        confirmBoardCreation();
        returnToHomePage();
    }




    public void changeBackground(){
        click(cssSelector(".js-change-background"));
        click(cssSelector(".js-bg-photos"));
        click(xpath("//div[@id='surface']//div[8]//span[1]"));
    }
    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void changeName() {
//    //click on name
        wd.findElement(By.cssSelector(".js-rename-board")).click();
//    //type text and enter
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("ggg" + Keys.ENTER);
        //type(By.cssSelector(".js-rename-board"), "ggg"+ Keys.ENTER);

    }
    public void openBoardsPage() {
        click(By.cssSelector("[href$=boards]"));
    }

}


