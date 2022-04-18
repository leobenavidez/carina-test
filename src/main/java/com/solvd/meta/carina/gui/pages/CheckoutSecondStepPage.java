package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutSecondStepPage extends AbstractPage {
    @FindBy(xpath = "//button[@id='cancel']")
    private ExtendedWebElement cancel;
    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finish;
    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public CheckoutSecondStepPage(WebDriver driver) {
        super(driver);
    }
    public InventoryPage clickCancel(){
        cancel.click();
        return new InventoryPage(driver);
    }
    public CheckoutFinish clickFinish(){
        finish.click();
        return new CheckoutFinish(driver);
    }
    public Header getHeader(){return header;}
}
