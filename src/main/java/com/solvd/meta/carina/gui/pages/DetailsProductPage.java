package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
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
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private ExtendedWebElement backToProductsButton;

    public DetailsProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(img);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDesc() {
        return itemDesc.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public InventoryPage clickBackToProducts(){
        backToProductsButton.click();
        return new InventoryPage(driver);
    }

    public Header getHeader(){return header;}
}
