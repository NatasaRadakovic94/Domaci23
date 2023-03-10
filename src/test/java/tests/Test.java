package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Pages;

import java.time.Duration;

public class Test {

    WebDriver driver;
    WebDriverWait driverWait;
    Pages pages;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //pages = new Pages(driver);
    }

    @BeforeMethod
    public void openWebsite(){
        driver.get("https://www.saucedemo.com/");
    }


    @org.testng.annotations.Test
    public void test1() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pages.doLogin("standard_user", "secret_sauce");
    }

    @org.testng.annotations.Test
    public void test2(){
        pages.doLogin("locked_out_user", "secret_sauce");
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @org.testng.annotations.Test
    public void test3(){
        pages.doLogin("standard_user", "ABC15545");
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @org.testng.annotations.Test
    public void test4(){
        pages.doLogin("standard_user", "secret_sauce");

    }

    @AfterClass
    public void driverQuit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

