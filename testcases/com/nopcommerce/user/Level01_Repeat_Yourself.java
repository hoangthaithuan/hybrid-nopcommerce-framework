package com.nopcommerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level01_Repeat_Yourself {

    private WebDriver driver;
    private String firstName, lastName, emailAdress, companyName, passWord;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "Trent";
        lastName = "Hoang";
        emailAdress = "Trent" + generateRandomNumber() + "@gmail.com";
        companyName = "Digityze";
        passWord = "Trent@12345";
    }

    @Test
    public void TC01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

    }

    @Test
    public void TC02_Login() throws InterruptedException {
        driver.findElement(By.cssSelector("a.ico-logout")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("a.ico-account")).isDisplayed());
    }

    @Test
    public void TC03_MyAccount() {
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private int generateRandomNumber() {
        return new Random().nextInt(999);
    }
}
