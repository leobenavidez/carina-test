package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//button[@id='continue-shopping']")
    private ExtendedWebElement continueShopping;
    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkout;
    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public InventoryPage clickContinueShopping(){
        continueShopping.click();
        return new InventoryPage(driver);
    }
    public Header getHeader(){return header;}
    public CheckOutPage clickCheckout(){
        checkout.click();
        return new CheckOutPage(driver);
    }
}
