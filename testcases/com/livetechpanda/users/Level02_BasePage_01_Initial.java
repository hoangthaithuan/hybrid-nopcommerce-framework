package com.livetechpanda.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level02_BasePage_01_Initial {

    WebDriver driver;

    BasePage basePage; // Initial

    String firstName, lastName, emailAdress, companyName, passWord;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        basePage = new BasePage();
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
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", lastName);

        basePage.getElement(driver, "//input[@id='Email']").clear();
        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAdress);
        basePage.sendKeyToElement(driver, "//input[@id='Company']", emailAdress);
        basePage.getElement(driver, "//input[@id='Password']").clear();
        basePage.sendKeyToElement(driver, "//input[@id='Password']", passWord);
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", passWord);
        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"),
                "Your registration completed");

    }

    @Test
    public void TC02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");

        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.getElement(driver, "//input[@id='Email']").clear();
        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAdress);
        basePage.getElement(driver, "//input[@id='Password']").clear();
        basePage.sendKeyToElement(driver, "//input[@id='Password']", passWord);
        basePage.clickToElement(driver, "//button[contains(@class,'login-button')]");
        basePage.waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver, "//button[contains(@class,'login-button')]");

        Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account']"));
    }

    @Test
    public void TC03_MyAccount() {
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private int generateRandomNumber() {
        return new Random().nextInt(999);
    }
}
