package com.livetechpanda.users;

import commons.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveTechPD.PageGenerator;
import pageObjects.liveTechPD.user.*;

public class Level07_Dynamic_Locator extends BaseTest {

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
    public void User_04_Dynamic_Page () {
        // My account -> Address
        addressPage = (UserAddressPO) myAccPage.openSidebarLinkByPageName("Address Book");

        // Address -> Order
        orderPage = (UserOrderPO) addressPage.openSidebarLinkByPageName("My Orders");

        // Order -> Prod Review
        prodReviewPage = (UserProdReviewsPO) orderPage.openSidebarLinkByPageName("My Product Reviews");

        // Prod Review -> Address
        addressPage = (UserAddressPO) prodReviewPage.openSidebarLinkByPageName("Address Book");

        // Address -> My account
        myAccPage = (UserMyaccountPO) addressPage.openSidebarLinkByPageName("Account Dashboard");
    }

    // cách này áp dụng cho trường hợp nhiều page
    @Test
    public void User_05_Dynamic_Page() {
        // My account -> Address
        myAccPage.openSidebarLinkByPageNames("Address Book");
        addressPage = PageGenerator.getUserAddressPage(driver);

        // Address -> Order
        addressPage.openSidebarLinkByPageNames("My Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        // Order -> Prod Review
        orderPage.openSidebarLinkByPageNames("My Product Reviews");
        prodReviewPage = PageGenerator.getUserProdReviewPage(driver);

        // Prod Review -> Address
        prodReviewPage.openSidebarLinkByPageNames("Address Book");
        addressPage = PageGenerator.getUserAddressPage(driver);

        // Address -> My account
        addressPage.openSidebarLinkByPageNames("Account Dashboard");
        myAccPage = PageGenerator.getUserMyAccountPage(driver);
    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
