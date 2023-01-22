package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Pages;

public class Test {

    WebDriver driver;
    Pages pages;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        pages = new Pages(driver);
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

