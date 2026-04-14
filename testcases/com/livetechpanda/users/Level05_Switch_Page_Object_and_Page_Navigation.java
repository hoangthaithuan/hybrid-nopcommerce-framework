package com.livetechpanda.users;

import commons.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

public class Level05_Switch_Page_Object_and_Page_Navigation extends BaseTest {

    // Declare variable
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserMyaccountPO myAccPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserProdReviewsPO prodReviewPage;

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
        homePage = new UserHomePO(driver);
    }

    // Testcases
    @Test
    public void User_01_Register() {
        homePage.clickToAccountMenu();
        homePage.openRegisterPage();
//
//        // Từ homepage qua register page
//        // Page đó sinh ra và bắt đầu hành động làm những action của page đó -> khởi tạo = new lên
        registerPage = new UserRegisterPO(driver);
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAdress);
        registerPage.enterToPasswordTextBox(passWord);
        registerPage.enterToConfirmPasswordTextBox(passWord);
        registerPage.clickToRegisterButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        homePage = new UserHomePO(driver);
        Assert.assertEquals(homePage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }

    @Test
    public void User_02_Login() {
        homePage.clickToAccountMenu();
        homePage.clickToLogoutLink();

        homePage.clickToAccountMenu();
        homePage.openLoginPage();

        loginPage = new UserLoginPO(driver);
        loginPage.enterToEmailTextbox(emailAdress);
        loginPage.enterToPasswordTextbox(passWord);
        loginPage.openMyAccountPage();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        myAccPage = new UserMyaccountPO(driver);
        Assert.assertTrue(myAccPage.isHelloTextDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        Assert.assertTrue(myAccPage.isTitleDisplayed());
        Assert.assertEquals(myAccPage.getValueOfAttribute(), "http://live.techpanda.org/index.php/customer/account/edit/");
    }

    @Test
    public void User_04_Switch_Page () {
        // My account -> Address
        addressPage = myAccPage.openAddressPage();

        // Address -> Order
        orderPage = addressPage.openOrderPage();

        // Order -> Prod Review
        prodReviewPage = orderPage.openProdReviewPage();

        // Prod Review -> Address
        addressPage = prodReviewPage.openAddressPage();

        // Address -> My account
        myAccPage = addressPage.openMyAccPage();
    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
