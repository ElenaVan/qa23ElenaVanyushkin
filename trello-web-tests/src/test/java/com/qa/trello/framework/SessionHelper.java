package com.qa.trello.framework;

import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login"))).click();
        click(id("login"));
    }

    public void fillloginForm(String userEmail, String password) {
        type(name("user"), userEmail);
        click(id("password"));
        type(id("password"), password);
    }

    public void initLogin() {
        click(cssSelector("[href='/login']"));
    }

    public void login(String email, String password) {
        initLogin();
        fillloginForm(email, password);
        confirmLogin();
    }
}
