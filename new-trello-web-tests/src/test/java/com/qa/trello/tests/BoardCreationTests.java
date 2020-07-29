package com.qa.trello.tests;

import com.qa.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase{
@BeforeMethod
public void ensurePreconditions() throws InterruptedException {
    Thread.sleep(3000);
    if(!app.getBoard().isOnBoardsPage()){
        app.getBoard().goToBoardsPageUrl("lenavanyushkina");
    }
}

@DataProvider
public Iterator<Object[]> validBoardsEasy() throws  IOException{
   List<Object[]> list = new ArrayList<>() ;
   list.add(new Object[]{"aaaa","No team"});
   list.add(new Object[]{"111111","No team"});
   list.add(new Object[]{"huhuhuhh","No team"});
   return list.iterator();




}
@DataProvider
public Iterator<Object[]> validBoards() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
    String line = reader.readLine();
    while (line != null){
        String[] split = line.split(";");
        list.add(new Object[] {new Board().withName(split[0]).withTeam(split[1])});
        reader.readLine();
    }

    return list.iterator();
}



    @Test (dataProvider =  "validBoardsEasy")
    public void testBoardCreation(String boardName, String boardTeam) {
    Board board = new Board().withName(boardName).withTeam(boardTeam);
     int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(board);

        //.withColor("red"));
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
      Assert.assertEquals(after,before+1);




}
}

