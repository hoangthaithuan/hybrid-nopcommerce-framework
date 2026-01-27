package com.livetechpanda.users;

import commons.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level05_Page_Generator extends BaseTest {
    /*
                    10 bước để bắt đầu build

             1 - Phân tích testcase về mặt tính năng/nghiệp vụ để xác định số page/flow như nào
             2 - Vẽ lại flow đó
             3 - Tạo POP
             4 - Tạo test class
             5 - Viết hàm giả trên Test Class
             6 - Implement các hàm trên Page Object Class
             7 - Define các locator ở Page UI Class: bao nhiêu class bên Page Object -> bấy nhiêu bên Page UI
             8 - Ráp UI/locator vào bên Page Object Class, ráp action bên basepage, và map được driver: dùng các hàm bên BasePagef
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
        homePage = PageGenerator.getHomePage(driver);
    }

    // Testcases
    @Test
    public void User_01_Register() {
        homePage.clickToAccountMenu();
        registerPage = homePage.clickToRegisterLink();
//
//        // Từ homepage qua register page
//        // Page đó sinh ra và bắt đầu hành động làm những action của page đó -> khởi tạo = new lên
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAdress);
        registerPage.enterToPasswordTextBox(passWord);
        registerPage.enterToConfirmPasswordTextBox(passWord);
        homePage = registerPage.clickToRegisterButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(homePage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");


    }

    @Test
    public void User_02_Login() {
        homePage.clickToAccountMenu();
        homePage.clickToLogoutLink();

        homePage.clickToAccountMenu();
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAdress);
        loginPage.enterToPasswordTextbox(passWord);
        myAccPage = loginPage.clickToLoginButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

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
