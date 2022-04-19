package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutSecondStepPage extends AbstractPage {

    @FindBy(xpath = "//button[@id='cancel']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public CheckoutSecondStepPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage clickCancel(){
        cancelButton.click();
        return new InventoryPage(driver);
    }

    public CheckoutFinish clickFinish(){
        finishButton.click();
        return new CheckoutFinish(driver);
    }

    public Header getHeader(){return header;}
}
