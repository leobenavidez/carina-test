package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends AbstractPage {
    @FindBy(xpath = "//button[@id='cancel']")
    private ExtendedWebElement cancel;
    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueButton;
    @FindBy(xpath = "//input[@data-test='firstName']")
    private ExtendedWebElement firstName;
    @FindBy(xpath = "//input[@data-test='lastName']")
    private ExtendedWebElement lastName;
    @FindBy(xpath = "//input[@data-test='postalCode']")
    private ExtendedWebElement postalCode;
    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public CartPage clickCancel(){
        cancel.click();
        return new CartPage(driver);
    }
    public CheckoutSecondStepPage clickContinue(){
        continueButton.click();
        return new CheckoutSecondStepPage(driver);
    }
    public void setFirstName(String firstName){
        this.firstName.type(firstName);
    }
    public void setLastName(String lastName){
        this.lastName.type(lastName);
    }
    public void setPostalCode(String postalCode){
        this.postalCode.type(postalCode);
    }
    public Header getHeader(){return header;}
}
