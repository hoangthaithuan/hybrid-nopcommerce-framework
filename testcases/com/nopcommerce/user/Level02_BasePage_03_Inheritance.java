package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level02_BasePage_03_Inheritance extends BasePage {
    // con kế thừa cha nên có thể dùng trực tiếp hàm của thằng cha luôn
    // gọi thẳng ra dùng luôn ko cần khai báo hay khởi tạo obj dùng
    WebDriver driver;


    String firstName, lastName, emailAdress, companyName, passWord;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();


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
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);

        getElement(driver, "//input[@id='Email']").clear();
        sendKeyToElement(driver, "//input[@id='Email']", emailAdress);
        sendKeyToElement(driver, "//input[@id='Company']", emailAdress);
        getElement(driver, "//input[@id='Password']").clear();
        sendKeyToElement(driver, "//input[@id='Password']", passWord);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", passWord);
        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[@class='result']"),
                "Your registration completed");

    }

    @Test
    public void TC02_Login() {
        waitForElementClickable(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");

        sleepInSecond(5000);

        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");

        getElement(driver, "//input[@id='Email']").clear();
        sendKeyToElement(driver, "//input[@id='Email']", emailAdress);
        getElement(driver, "//input[@id='Password']").clear();
        sendKeyToElement(driver, "//input[@id='Password']", passWord);
        clickToElement(driver, "//button[contains(@class,'login-button')]");
        waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        clickToElement(driver, "//button[contains(@class,'login-button')]");

        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
    }

    @Test
    public void TC03_MyAccount() {
        clickToElement(driver, "//a[@class='ico-account']");
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(999);
    }
}
