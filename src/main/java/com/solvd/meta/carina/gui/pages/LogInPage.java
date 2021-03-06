package com.solvd.meta.carina.gui.pages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LogInPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@data-test='username']")
    private ExtendedWebElement username;
    @FindBy(xpath = "//input[@data-test='password']")
    private ExtendedWebElement password;
    @FindBy(xpath = "//input[@data-test='login-button']")
    private ExtendedWebElement logIn;

    @FindBy(xpath = "//h3[@data-test='error']")
    private ExtendedWebElement errorMesage;

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logIn);
    }

    public void setUsername(String keys) {
        this.username.type(keys);
    }

    public void setPassword(String keys) {
        assertElementPresent(password);
        this.password.type(keys);
    }

    public InventoryPage clickLogIn() {
        logIn.click();
        return new InventoryPage(getDriver());
    }

    public boolean errorMesaggeIsPresent(){
        return errorMesage.isPresent();
    }
}
