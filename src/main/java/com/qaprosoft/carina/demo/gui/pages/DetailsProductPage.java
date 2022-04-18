package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsProductPage {
    @FindBy(xpath = "//img[@class='inventory_details_img']")
    private ExtendedWebElement img;
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private ExtendedWebElement itemName;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private ExtendedWebElement itemDesc;
    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private ExtendedWebElement price;
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private ExtendedWebElement addToCart;

    public ExtendedWebElement getItemName() {
        return itemName;
    }

    public ExtendedWebElement getItemDesc() {
        return itemDesc;
    }

    public ExtendedWebElement getPrice() {
        return price;
    }

    public ExtendedWebElement getAddToCart() {
        return addToCart;
    }

    public ExtendedWebElement getImg(){return img;}
}
