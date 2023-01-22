package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "id=\"add-to-cart-sauce-labs-backpack\"")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cart;

    @FindBy(id = "id=\"remove-sauce-labs-backpack\"")
    private WebElement removeButton;

//    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
//    private WebElement errorMessage;

    public Pages (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }
    public void fillUsernamePassword(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }
    public void loginClick(){
        loginButton.click();
    }
    public void doLogin(String username, String password){
        fillUsernamePassword(username, password);
        loginClick();
    }
    public void setAddToCart(){
        addButton.click();
    }
    public void removeFromCart(){
        removeButton.click();
    }
    //public void error(String expectedMessage, String errorMessage)

}
