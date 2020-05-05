package com.qa.trello.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager<WebDriver> {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    String browser;

    public ApplicationManager(String browser) {


        public void init() throws InterruptedException {
            if(browser.equals(BrowserType.CHROME)){
                wd = (WebDriver) new ChromeDriver();
            }if(browser.equals(BrowserType.FIREFOX)){
                wd = new FirefoxDriver();
            }if(browser.equals(BrowserType.EDGE)){
                wd = new EdgeDriver();}

            }
            wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            // WebDriverWait wait = new WebDriverWait(wd, 45);
            wd.manage().window().maximize();
            wd.navigate().to("https://trello.com/");

            session = new SessionHelper(wd);
            session.login("vanyushkinelena@gmail.com", "felia161075");

            board = new BoardHelper(wd);
            team =  new TeamHelper(wd);

        }

        public void stop() {
            wd.quit();
        }

        public BoardHelper getBoard() {
            return board;
        }

        public TeamHelper getTeam() {
            return team;
        }

        public SessionHelper getSession() {
            return session;
        }
    }



}
