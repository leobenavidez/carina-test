package com.solvd.meta.carina.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.meta.carina.gui.pages.CartPage;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    private ExtendedWebElement allItemsButton;

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    private ExtendedWebElement aboutButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    private ExtendedWebElement resetStateButton;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickMenu() {
        menuButton.click();
    }

    public CartPage clickCart() {
        cartButton.click();
        return new CartPage(driver);
    }

    public LogInPage clickLogout() {
        assertElementPresent(logoutButton);
        logoutButton.click();
        return new LogInPage(driver);
    }

    public InventoryPage clickAllItems() {
        assertElementPresent(allItemsButton);
        allItemsButton.click();
        return new InventoryPage(driver);
    }

    public void clickResetState() {
        assertElementPresent(resetStateButton);
        resetStateButton.click();
    }

}
