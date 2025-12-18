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
        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");

        waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Register']");
        clickToElement(driver,"//div[@id='header-account']//li/a[@title='Register']");

        sendKeyToElement(driver, "//input[@id='firstname']", firstName);
        sendKeyToElement(driver, "//input[@id='lastname']", lastName);

        sendKeyToElement(driver, "//input[@id='email_address']", emailAdress);
        sendKeyToElement(driver, "//input[@id='password']", passWord);
        sendKeyToElement(driver, "//input[@id='confirmation']", passWord);
        waitForElementClickable(driver, "//button[@title='Register']");
        clickToElement(driver, "//button[@title='Register']");

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(getElementText(driver, "//li[@class='success-msg']//span"),
                "Thank you for registering with Main Website Store.");

    }

    @Test
    public void TC02_Login() {
        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");

        waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Log Out']");
        clickToElement(driver, "//div[@id='header-account']//li/a[@title='Log Out']");

        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");

        waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Log In']");
        clickToElement(driver, "//div[@id='header-account']//li/a[@title='Log In']");

        sendKeyToElement(driver, "//input[@id='email']", emailAdress);
        sendKeyToElement(driver, "//input[@id='pass']", passWord);
        waitForElementClickable(driver, "//button[@id='send2']");
        clickToElement(driver, "//button[@id='send2']");

        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
        Assert.assertTrue(isElementDisplayed(driver, "//p[@class='hello']//strong"));
    }

    @Test
    public void TC03_MyAccount() {
        Assert.assertEquals(getElementText(driver, "//div[@class='box-title']//h3"), "Contact Information");
        Assert.assertEquals(getElementAttribute(driver, "//div[@class='box-title']//a", "href"), "http://live.techpanda.org/index.php/customer/account/edit/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(999);
    }
}
