package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
@BeforeMethod
public void ensurePreconditions() throws InterruptedException {
    if(!app.getBoard().isOnBoardsPage()) {
        app.getBoard().waitForElementClickableAndClick(By.cssSelector("[href$=boards"), 20);
    }
}

    @Test
    public void testTeamCreation() throws InterruptedException {
        app.getTeam().initTeamCreation();
        app.getTeam().fillForm("Team_test", By.cssSelector("[class='_38pq5NbRWAG39y']"));
        app.getTeam().confirmTeamCreation();
        Thread.sleep(2000);
        app.getTeam().inviteTeamLater();
        app.getTeam().returnToHomePage();

    }

}
