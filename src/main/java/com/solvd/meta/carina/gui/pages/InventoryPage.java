package com.solvd.meta.carina.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.meta.carina.gui.components.Header;
import com.solvd.meta.carina.gui.components.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<Product> products;

    @FindBy(xpath = "//div[@class='primary_header']")
    private Header header;

    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    private ExtendedWebElement sort;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(sort);
    }

    public Product getProducts(int pos) {
        return products.get(pos);
    }

    public ExtendedWebElement getSort() {
        return sort;
    }

    public Header getHeader() {
        return header;
    }


}
