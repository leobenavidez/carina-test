package com.solvd.meta.carina.gui.utils;


import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.testng.Assert;



public class AuthService implements IDriverPool {

    public AuthService() {
    }

    public InventoryPage login(String userName, String userPassword) {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(userName);
        loginPage.setPassword(userPassword);
        return loginPage.clickLogIn();
    }
}
