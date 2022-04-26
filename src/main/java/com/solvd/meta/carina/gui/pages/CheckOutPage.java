package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends AbstractPage {

    @FindBy(xpath = "//button[@id='cancel']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@data-test='firstName']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    private ExtendedWebElement postalCodeField;

    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
    }

    public CartPage clickCancel() {
        cancelButton.click();
        return new CartPage(driver);
    }

    public CheckoutSecondStepPage clickContinue() {
        continueButton.click();
        return new CheckoutSecondStepPage(driver);
    }

    public void setFirstName(String firstName) {
        this.firstNameField.type(firstName);
    }

    public void setLastName(String lastName) {
        this.lastNameField.type(lastName);
    }

    public void setPostalCode(String postalCode) {
        this.postalCodeField.type(postalCode);
    }

    public Header getHeader() {
        return header;
    }

}
