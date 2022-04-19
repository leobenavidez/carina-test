package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.solvd.meta.carina.gui.components.Product;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class TestCase1 implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    LogInPage login = null;

    InventoryPage inventoryPage=null;

    @BeforeSuite
    public void startDriver() {
        // Open saucedemo.com home page and verify page is opened
        login = new LogInPage(getDriver());
    }

    @Test
    public void testOpenPage(){
        login.open();
        Assert.assertTrue(login.isPageOpened(), "Home page is not opened");
    }

    @Test(dependsOnMethods="testOpenPage")
    public void logIn(){
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        inventoryPage= login.clickLogIn();
        Assert.assertTrue(login.isPageOpen(), "Login succesfull");
        Product p1= inventoryPage.getProducts(0);
        Product p2= inventoryPage.getProducts(1);
        LOGGER.info(p1.getItemName());
        LOGGER.info(p2.getItemName());

    }
}
