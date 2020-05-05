package com.qa.trello.framework;

import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class TeamHelper extends HelperBase {
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void fillTeamForm(String nameOfTeam) {
        type(By.cssSelector("[data-test-id=header-create-team-name-input]"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
    }


    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
    }


    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));
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
