package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cart;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessage;

    public CartPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }
}
