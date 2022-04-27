package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.meta.carina.gui.components.Product;
import com.solvd.meta.carina.gui.pages.DetailsProductPage;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.utils.AuthService;
import com.solvd.meta.carina.gui.utils.TakeScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckProductDetailScreenTest implements IAbstractTest {

    @Test
    public void checkDetailsTest() {
        InventoryPage inventoryPage = new AuthService().login(R.TESTDATA.get("standard_username"), R.TESTDATA.get("standard_user_password"));
        for (int a = 0; a < inventoryPage.getAllProducts().size(); a++) {
            Product product = inventoryPage.getProducts(a);
            DetailsProductPage detailsProductPage = product.clickImage();
            Assert.assertTrue(detailsProductPage.isPresentItemName(), "The name of the product is not displayed");
            Assert.assertTrue(detailsProductPage.isPresentImage(), "The image of the product" + detailsProductPage.getItemName() + "is not displayed ");
            Assert.assertTrue(detailsProductPage.isPresentItemDesc(), "The description of the product" + detailsProductPage.getItemName() + "is not displayed ");
            Assert.assertTrue(detailsProductPage.isPresentPrice(), "The price of the product" + detailsProductPage.getItemName() + "is not displayed ");
            new TakeScreenshot().makeScreenshot();
            inventoryPage = detailsProductPage.clickBackToProducts();
        }
        Assert.assertTrue(inventoryPage.isPageOpened(), "Error occurred");
    }
}
