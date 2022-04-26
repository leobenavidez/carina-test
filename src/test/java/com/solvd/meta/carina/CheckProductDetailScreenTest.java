package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.meta.carina.gui.components.Product;
import com.solvd.meta.carina.gui.pages.DetailsProductPage;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckProductDetailScreenTest implements IAbstractTest {

    private InventoryPage login(String username, String password) {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        return loginPage.clickLogIn();
    }

    @Test
    public void checkDetailsTest() {
        InventoryPage inventoryPage = login(R.TESTDATA.get("standard_username"), R.TESTDATA.get("standard_user_password"));
        for (int a = 0; a < inventoryPage.getAllProducts().size(); a++) {
            Product product = inventoryPage.getProducts(a);
            DetailsProductPage detailsProductPage = product.clickImage();
            Assert.assertTrue(detailsProductPage.isPresentItemName(), "The name of the product is not displayed");
            Assert.assertTrue(detailsProductPage.isPresentImage(), "The image of the product" + detailsProductPage.getItemName() + "is not displayed ");
            Assert.assertTrue(detailsProductPage.isPresentItemDesc(), "The description of the product" + detailsProductPage.getItemName() + "is not displayed ");
            Assert.assertTrue(detailsProductPage.isPresentPrice(), "The price of the product" + detailsProductPage.getItemName() + "is not displayed ");
            inventoryPage = detailsProductPage.clickBackToProducts();
        }
        Assert.assertTrue(inventoryPage.isPageOpened(), "Error occurred");
    }
}
