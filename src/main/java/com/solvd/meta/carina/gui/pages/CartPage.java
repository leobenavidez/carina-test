package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueShoppingButton);
    }

    public InventoryPage clickContinueShopping(){
        continueShoppingButton.click();
        return new InventoryPage(driver);
    }

    public Header getHeader(){return header;}

    public CheckOutPage clickCheckout(){
        assertElementPresent(checkoutButton);
        checkoutButton.click();
        return new CheckOutPage(driver);
    }
}
