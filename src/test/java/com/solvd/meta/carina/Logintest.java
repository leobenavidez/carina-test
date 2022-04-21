package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.solvd.meta.carina.gui.components.Product;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class Logintest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test
    public void loginTest() {
        LogInPage loginPage = new LogInPage(getDriver());
        InventoryPage inventoryPage = null;
        loginPage.open();
        Assert.assertFalse(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogIn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login succesfull");
    }
}
