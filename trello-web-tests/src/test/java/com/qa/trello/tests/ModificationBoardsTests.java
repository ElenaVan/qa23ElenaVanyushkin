package com.qa.trello.tests;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;

public class ModificationBoardsTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().openBoardsPage();
        }
        if(app.getBoard().getBoardsCount()==0){
            app.getBoard().createBoard();
        }
    }

    @Test
    public void modifiBoards(){
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().changeBackground();
        //changeName();
        app.getSession().returnToHomePage();


    }

    public void changeName() {
        app.getBoard().wd.findElement(By.cssSelector(".js-rename-board"));
        app.getBoard().wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("rrur"+ Keys.ENTER);
        //type(By.cssSelector(".js-rename-board"), "rrr"+ Keys.ENTER);

    }
}
