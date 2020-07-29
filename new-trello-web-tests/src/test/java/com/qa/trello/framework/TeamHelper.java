package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void fillForm(String name, By locatorTeamType) {
        typeNameOfTeam(name);
        selectTeamType(locatorTeamType);

    }

    public void selectTeamType(By locatorTeamType) {
        waitForElementLocatedAndClick(By.id("teamTypeSelect"),20);
        waitForElementLocatedAndClick(locatorTeamType, 20);
    }

    public void typeNameOfTeam(String name) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), name);
    }

    public void confirmTeamCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[type='submit']"),20);
        waitForElementLocatedAndClick(By.cssSelector("[class='eg0KI5SqghoOFd']"),20);
    }

    public void initTeamCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"),20);
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            waitForElementLocatedAndClick(By.cssSelector("[data-test-id=show-later-button]"),20);
        }
    }

    public void openTeamSettings() {
        openFirstTeam();
        openSettings();
    }

    public void openSettings() {
    }

    public void openFirstTeam() {
    }
}
