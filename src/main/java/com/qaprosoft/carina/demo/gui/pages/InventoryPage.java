package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage {
    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<ExtendedWebElement> products;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement menu;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cart;
    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    private ExtendedWebElement sort;

    public List<ExtendedWebElement> getProducts(){return products;}
    public ExtendedWebElement getMenu(){return menu;}
    public ExtendedWebElement getSort(){return sort;}
}
