package com.solvd.meta.carina.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import com.solvd.meta.carina.gui.pages.LogInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy (xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement menu;
    @FindBy (xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cart;
    @FindBy (xpath = "//a[@id='inventory_sidebar_link']")
    private ExtendedWebElement allItems;
    @FindBy (xpath = "//a[@id='about_sidebar_link']")
    private ExtendedWebElement about;
    @FindBy (xpath = "//a[@id='logout_sidebar_link']")
    private ExtendedWebElement logout;
    @FindBy (xpath = "//a[@id='reset_sidebar_link']")
    private ExtendedWebElement resetState;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public void clickMenu(){menu.click();}
    public void clickCart(){cart.click();}
    public LogInPage clickLogout(){
        assertElementPresent(logout);
        logout.click();
        return new LogInPage(driver);
    }
    public InventoryPage clickAllItems(){
        assertElementPresent(allItems);
        allItems.click();
        return new InventoryPage(driver);
    }
    public void clickResetState(){
        assertElementPresent(resetState);
        resetState.click();
    }

}
