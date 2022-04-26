package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest implements IAbstractTest {

    @Test
    public void loginTest() {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(R.TESTDATA.get("standard_username"));
        loginPage.setPassword(R.TESTDATA.get("standard_user_password"));
        InventoryPage inventoryPage = loginPage.clickLogIn();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Login failed after click login button");
    }

    @Test
    public void loginLockedUserTest() {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(R.TESTDATA.get("locked_user"));
        loginPage.setPassword(R.TESTDATA.get("standard_user_password"));
        InventoryPage inventoryPage = loginPage.clickLogIn();
        Assert.assertTrue(loginPage.errorMesaggeIsPresent(), "Login approved after click login button");
    }
}
