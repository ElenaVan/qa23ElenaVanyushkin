package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{

    @Test
    public void testBoardCreation() {
     int before = app.getBoard().getBoardsCount();
        app.getBoard().createBoard();
        int after = app.getBoard().getBoardsCount();
      Assert.assertEquals(after,before+1);


    }

}

