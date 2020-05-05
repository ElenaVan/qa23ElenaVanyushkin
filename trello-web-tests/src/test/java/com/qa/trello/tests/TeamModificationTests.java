package com.qa.trello.tests;

import org.junit.Test;

public class TeamModificationTests extends TestBase {
    @Test
    public void TestTeammodification() {
        app.getTeam().openTeamSettings();
    }
}
