package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.cssSelector("[class=title]");
    private final By TITLE2 = (By.xpath("//*[text()='Products']"));
    private final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public boolean titleDisplayed() {
        driver.findElement(TITLE2).isDisplayed();
        return true;
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();

    }

}

