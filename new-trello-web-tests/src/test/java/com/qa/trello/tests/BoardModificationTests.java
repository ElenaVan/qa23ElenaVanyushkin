package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
    if(!isOnBoardsPage()){
        click(By.cssSelector("[href$=boards]"));

    }
    if(getBoardsCount()==0){
        createBoard();
    }
}
@Test
    public void testBoardNameMOdification(){
    openFirstPersonalBoard();
    changeName();
    returnToHomePage();

}

}
