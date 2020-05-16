package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardDeletionTest extends TestBase {



    @Test
    public void testBoardDeletion() {
         int before = getBoardsCount();
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletionInMoreMenu();

        permanentlyDeleteBoard();
        returnToHomePage();
          int after = getBoardsCount();
          System.out.println("was: " + before+ " now: " + after );
        Assert.assertEquals(after,before-1);


    }

}
