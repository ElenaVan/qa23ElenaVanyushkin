package com.qa.trello.tests;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{
    @Test
    public void testBoardDeletion() {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletionInBoardMenu();

        app.getBoard().permanentlyDeletBoard();
        app.getSession().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was:" + before + " now: " + after);
        Assert.assertEquals(after, before - 1);


    }
}
