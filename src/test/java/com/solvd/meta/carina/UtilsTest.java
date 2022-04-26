package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.utils.AuthService;
import com.solvd.meta.carina.gui.utils.TakeScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilsTest implements IAbstractTest {

    @Test
    public void utilsTest(){
        AuthService authService = new AuthService();
        InventoryPage inventoryPage = authService.login(R.TESTDATA.get("standard_username"),R.TESTDATA.get("standard_user_password"));
        TakeScreenshot takeScreenshot = new TakeScreenshot();
        takeScreenshot.makeScreenshot("UtilsTest");
        Assert.assertTrue(inventoryPage.isPageOpened(), "Login successful");
    }
}
