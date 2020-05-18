package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
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
    public void testBoardNameMOdification(){
    app.getBoard().openFirstPersonalBoard();
    app.getBoard().changeName();
    app.getBoard().returnToHomePage();

}

}
