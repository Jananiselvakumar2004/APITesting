package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  LoginTest {

    WebDriver driver;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/opt/homebrew/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Browser opened");
    }


    @Test
    public void loginTest() throws InterruptedException {


        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println(" Opened website");


        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        System.out.println(" Typed username");


        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        System.out.println("Typed password");


        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        System.out.println("Clicked submit");

        Thread.sleep(2000);


        String url = driver.getCurrentUrl();
        System.out.println("🔗 URL: " + url);

        if (url.contains("logged-in-successfully")) {
            System.out.println(" LOGIN SUCCESS!");
        } else {
            System.out.println(" LOGIN FAILED!");
        }

        Assert.assertTrue(url.contains("logged-in-successfully"));
    }


    @AfterTest
    public void teardown() {
        driver.quit();
        System.out.println(" Browser closed");
    }
}