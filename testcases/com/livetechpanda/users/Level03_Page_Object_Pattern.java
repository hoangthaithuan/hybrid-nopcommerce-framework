package com.livetechpanda.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyaccountPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level03_Page_Object_Pattern extends BaseTest {
    /*
                    10 bước để bắt đầu build

             1 - Phân tích testcase về mặt tính năng/nghiệp vụ để xác định số page/flow như nào
             2 - Vẽ lại flow đó
             3 - Tạo POP
             4 - Tạo test class
             5 - Viết hàm giả trên Test Class
             6 - Implement các hàm trên Page Object Class
             7 - Define các locator ở Page UI Class: bao nhiêu class bên Page Object -> bấy nhiêu bên Page UI
             8 - Ráp UI/locator vào bên Page Object Class, ráp action bên basepage, và map được driver: dùng các hàm bên BasePage
             9 - Ráp data test vào bên Test Class
             10 - Run and Done
             --------------------------------------------------------------

             - Những đoạn nào cần khởi tạo page thì implement luôn
             - Các action có truyền tham số thì tham số là Data chứ ko phải locator
             - Chuyển đến trang nào thì new trang đó lên
             - Viết hàm giả trước - tạo hàm sau: giúp gợi ý nhanh hàm để tạo bên page object class

         */
    // Declare variable
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private MyaccountPageObject myAccPage;

    String firstName, lastName, emailAdress, passWord;

    // Pre-condition
    @Parameters ("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        // Data
        firstName = "Trent";
        lastName = "Hoang";
        emailAdress = "Trent" + generateRandomNumber() + "@gmail.com";
        passWord = "Trent@12345";

        // Page ảo được sinh ra và bắt đầu làm những action của page ảo đó
        homePage = new HomePageObject(driver);
    }

    // Testcases
    @Test
    public void User_01_Register() {
        homePage.clickToAccountMenu();
        homePage.clickToRegisterLink();
//
//        // Từ homepage qua register page
//        // Page đó sinh ra và bắt đầu hành động làm những action của page đó -> khởi tạo = new lên
        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAdress);
        registerPage.enterToPasswordTextBox(passWord);
        registerPage.enterToConfirmPasswordTextBox(passWord);
        registerPage.clickToRegisterButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        homePage = new HomePageObject(driver);
        Assert.assertEquals(homePage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

//        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//        clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//
//        waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Register']");
//        clickToElement(driver, "//div[@id='header-account']//li/a[@title='Register']");
//
//        sendKeyToElement(driver, "//input[@id='firstname']", firstName);
//        sendKeyToElement(driver, "//input[@id='lastname']", lastName);
//
//        sendKeyToElement(driver, "//input[@id='email_address']", emailAdress);
//        sendKeyToElement(driver, "//input[@id='password']", passWord);
//        sendKeyToElement(driver, "//input[@id='confirmation']", passWord);
//        waitForElementClickable(driver, "//button[@title='Register']");
//        clickToElement(driver, "//button[@title='Register']");
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        Assert.assertEquals(getElementText(driver, "//li[@class='success-msg']//span"),
//                "Thank you for registering with Main Website Store.");

    }

    @Test
    public void User_02_Login() {
        homePage.clickToAccountMenu();
        homePage.clickToLogoutLink();

        homePage.clickToAccountMenu();
        homePage.clickToLoginLink();

        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextbox(emailAdress);
        loginPage.enterToPasswordTextbox(passWord);
        loginPage.clickToLoginButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        myAccPage = new MyaccountPageObject(driver);
        Assert.assertTrue(myAccPage.isHelloTextDisplayed());

//        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//        clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//
//        waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Log Out']");
//        clickToElement(driver, "//div[@id='header-account']//li/a[@title='Log Out']");
//
//        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//        clickToElement(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//
//        waitForElementClickable(driver, "//div[@id='header-account']//li/a[@title='Log In']");
//        clickToElement(driver, "//div[@id='header-account']//li/a[@title='Log In']");
//
//        sendKeyToElement(driver, "//input[@id='email']", emailAdress);
//        sendKeyToElement(driver, "//input[@id='pass']", passWord);
//        clickToElement(driver, "//button[@id='send2']");
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//        Assert.assertTrue(isElementDisplayed(driver, "//p[@class='hello']//strong"));
    }

    @Test
    public void User_03_MyAccount() {
        Assert.assertTrue(myAccPage.isTitleDisplayed());
        Assert.assertEquals(myAccPage.getValueOfAttribute(), "http://live.techpanda.org/index.php/customer/account/edit/");
//        waitForElementClickable(driver, "//a[contains(@class,'skip-account')]/span[text()='Account']");
//        Assert.assertEquals(getElementText(driver, "//div[@class='box-title']//h3"), "Contact Information");
//        Assert.assertEquals(getElementAttribute(driver, "//div[@class='box-title']//a", "href"), "http://live.techpanda.org/index.php/customer/account/edit/");
    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
