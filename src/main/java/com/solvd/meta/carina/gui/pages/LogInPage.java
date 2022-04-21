package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.openqa.selenium.Keys;
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

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
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

    public boolean isPageOpened() {
        return username.isPresent();
    }
}
