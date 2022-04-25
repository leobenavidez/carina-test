package com.solvd.meta.carina.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.meta.carina.gui.pages.DetailsProductPage;
import com.solvd.meta.carina.gui.pages.InventoryPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject {

    @FindBy(xpath = ".//img[@class='inventory_item_img']")
    private ExtendedWebElement img;

    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//div[@class='inventory_item_desc']")
    private ExtendedWebElement itemDesc;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//button[@class='btn btn_primary btn_small btn_inventory']")
    private ExtendedWebElement addToCart;

    public DetailsProductPage clickImage() {
        img.click();
        return new DetailsProductPage(driver);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getDesc() {
        return itemDesc.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void clickAddToCart() {
        assertElementPresent(addToCart);
        addToCart.click();
    }

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
