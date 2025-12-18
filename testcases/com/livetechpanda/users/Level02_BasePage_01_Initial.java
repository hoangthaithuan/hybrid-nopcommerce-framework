package com.livetechpanda.users;

import commons.BasePage;
import org.openqa.selenium.Alert;
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

    String firstName, lastName, emailAdress, passWord;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        basePage = new BasePage();
        driver.get("https://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "Trent";
        lastName = "Hoang";
        emailAdress = "Trent" + generateRandomNumber() + "@gmail.com";
        passWord = "Trent@12345";
    }

    @Test
    public void TC01_Register() {
        basePage.waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        basePage.clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");

        basePage.waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Register']");
        basePage.clickToElement(driver,"//div[@id='header-account']//li/a[@title='Register']");

        basePage.sendKeyToElement(driver, "//input[@id='firstname']", firstName);
        basePage.sendKeyToElement(driver, "//input[@id='lastname']", lastName);

        basePage.sendKeyToElement(driver, "//input[@id='email_address']", emailAdress);
        basePage.sendKeyToElement(driver, "//input[@id='password']", passWord);
        basePage.sendKeyToElement(driver, "//input[@id='confirmation']", passWord);
        basePage.waitForElementClickable(driver, "//button[@title='Register']");
        basePage.clickToElement(driver, "//button[@title='Register']");

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(basePage.getElementText(driver, "//li[@class='success-msg']//span"),
                "Thank you for registering with Main Website Store.");

    }

    @Test
    public void TC02_Login() {
        basePage.waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        basePage.clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");

        basePage.waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Log Out']");
        basePage.clickToElement(driver, "//div[@id='header-account']//li/a[@title='Log Out']");

        basePage.waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        basePage.clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");

        basePage.waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Log In']");
        basePage.clickToElement(driver, "//div[@id='header-account']//li/a[@title='Log In']");

        basePage.sendKeyToElement(driver, "//input[@id='email']", emailAdress);
        basePage.sendKeyToElement(driver, "//input[@id='pass']", passWord);
        basePage.waitForElementClickable(driver, "//button[@id='send2']");
        basePage.clickToElement(driver, "//button[@id='send2']");

        basePage.waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//p[@class='hello']//strong"));
    }

    @Test
    public void TC03_MyAccount() {
        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='box-title']//h3"), "Contact Information");
        Assert.assertEquals(basePage.getElementAttribute(driver, "//div[@class='box-title']//a", "href"), "http://live.techpanda.org/index.php/customer/account/edit/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private int generateRandomNumber() {
        return new Random().nextInt(999);
    }
}
