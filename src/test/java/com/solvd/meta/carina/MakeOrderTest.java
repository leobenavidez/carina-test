package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.meta.carina.gui.components.Header;
import com.solvd.meta.carina.gui.components.Product;
import com.solvd.meta.carina.gui.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MakeOrderTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private InventoryPage login(String username, String password) {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        return loginPage.clickLogIn();
    }
    @Test
    public void makeOrderTest(){
        InventoryPage inventoryPage= login(R.TESTDATA.get("standard_username"), R.TESTDATA.get("standard_user_password"));
        Product productTest1= inventoryPage.getProducts(0);
        productTest1.clickAddToCart();
        Header header = inventoryPage.getHeader();
        CartPage cartPage= header.clickCart();
        CheckOutPage checkOutPage= cartPage.clickCheckout();
        checkOutPage.setFirstName(R.TESTDATA.get("first_name"));
        checkOutPage.setLastName(R.TESTDATA.get("last_name"));
        checkOutPage.setPostalCode(R.TESTDATA.get("zip_code"));
        CheckoutSecondStepPage checkoutSecondStepPage= checkOutPage.clickContinue();
        CheckoutFinish checkoutFinish= checkoutSecondStepPage.clickFinish();
        Assert.assertTrue(checkoutFinish.isPageOpened(), "Unexpected error");
    }

}
