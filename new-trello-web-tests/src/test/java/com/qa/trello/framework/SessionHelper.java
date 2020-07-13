package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String email, String password) {
        initLogin();
        fillLoginForm(email, password);
        confirmLogin();
    }
    public void confirmLogin() {
        clic(By.id("login"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }

    public void initLogin() {
      clic(By.cssSelector("[href='/login']"));
    }


}
