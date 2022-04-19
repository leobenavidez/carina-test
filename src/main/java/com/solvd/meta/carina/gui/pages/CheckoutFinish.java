package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutFinish extends AbstractPage {

    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private ExtendedWebElement backToHomeButton;

    public CheckoutFinish(WebDriver driver) {
        super(driver);
    }

    public InventoryPage clickBackHome(){
        backToHomeButton.click();
        return new InventoryPage(driver);
    }

    public Header getHeader(){return header;}
}
