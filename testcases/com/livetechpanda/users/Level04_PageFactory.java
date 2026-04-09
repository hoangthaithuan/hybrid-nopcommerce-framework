package com.livetechpanda.users;

import commons.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyaccountPageObject;
import pageObjects.RegisterPageObject;

public class Level04_PageFactory extends BaseTest {

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
        homePage.openRegisterPage();
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
    }

    @Test
    public void User_02_Login() {
        homePage.clickToAccountMenu();
        homePage.clickToLogoutLink();

        homePage.clickToAccountMenu();
        homePage.openLoginPage();

        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextbox(emailAdress);
        loginPage.enterToPasswordTextbox(passWord);
        loginPage.openMyAccountPage();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        myAccPage = new MyaccountPageObject(driver);
        Assert.assertTrue(myAccPage.isHelloTextDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        Assert.assertTrue(myAccPage.isTitleDisplayed());
        Assert.assertEquals(myAccPage.getValueOfAttribute(), "http://live.techpanda.org/index.php/customer/account/edit/");
    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
