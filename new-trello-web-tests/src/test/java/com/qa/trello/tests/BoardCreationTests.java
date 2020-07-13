package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{
@BeforeMethod
public void ensurePreconditions() throws InterruptedException {
    Thread.sleep(3000);
    if(!app.getBoard().isOnBoardsPage()){
        app.getBoard().goToBoardsPageUrl("lenavanyushkina");
    }
}
    @Test
    public void testBoardCreation() {
     int before = app.getBoard().getBoardsCount();
        app.getBoard().createBoard();
        int after = app.getBoard().getBoardsCount();
      Assert.assertEquals(after,before+1);


    }

}

