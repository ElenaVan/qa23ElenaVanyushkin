package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{

    @Test
    public void testBoardCreation() {
     int before = getBoardsCount();
        createBoard();
        int after = getBoardsCount();
      Assert.assertEquals(after,before+1);


    }

}

