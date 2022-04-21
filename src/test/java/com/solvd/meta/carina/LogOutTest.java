package com.solvd.meta.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.meta.carina.gui.components.Header;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest implements IAbstractTest {

    private InventoryPage login(String username, String password) {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        return loginPage.clickLogIn();
    }

    @Test
    public void logOutTest() {
        InventoryPage inventoryPage = login(R.TESTDATA.get("standard_username"), R.TESTDATA.get("standard_user_password"));
        Header header = inventoryPage.getHeader();
        header.clickMenu();
        LogInPage logInPage = header.clickLogout();
        Assert.assertTrue(logInPage.isPageOpened(), "You can not logout");
    }
}
