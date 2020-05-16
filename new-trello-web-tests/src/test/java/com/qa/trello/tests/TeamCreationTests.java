package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamCreationTests extends TestBase{


    @Test
    public void testTeamCreation() throws InterruptedException {
        initTeamCreation();
        fillForm("Team_test", By.cssSelector("[class='_38pq5NbRWAG39y']"));
        confirmTeamCreation();
        Thread.sleep(2000);
        inviteTeamLater();
        returnToHomePage();

    }

}
