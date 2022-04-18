package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DetailsProductPage extends AbstractPage {
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
    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public DetailsProductPage(WebDriver driver) {
        super(driver);
    }

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

    public Header getHeader(){return header;}
}
