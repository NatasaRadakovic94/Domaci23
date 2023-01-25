package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages extends BasePage{

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public Pages(WebDriver driver, WebDriverWait driverWait) {

        super(driver, driverWait);
    }

//    public Pages(WebDriver driver) {;
//        this.driver = driver;
//        PageFactory.initElements(this.driver, this);

    public void fillUsernamePassword(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void loginClick() {
        loginButton.click();
    }

    public void doLogin(String username, String password) {
        fillUsernamePassword(username, password);
        loginClick();
    }
}

