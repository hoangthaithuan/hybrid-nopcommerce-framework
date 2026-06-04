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
import pageObjects.liveTechPD.admin.AdminLoginPO;
import pageObjects.liveTechPD.user.UserHomePO;
import pageObjects.liveTechPD.user.UserLoginPO;
import pageObjects.liveTechPD.user.UserMyaccountPO;
import pageObjects.liveTechPD.user.UserRegisterPO;

public class Level06_Switch_Site_URL extends BaseTest {

    // Declare variable
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private UserMyaccountPO userMyAccPage;

    private AdminLoginPO adminLoginPage;

    private String userUrlValue, adminUrlValue;

    String firstName, lastName, emailAdress, passWord, adminUserName, adminPassword;

    // Pre-condition
    @Parameters ({"browser", "userURL", "adminURL"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;

        driver = getBrowserDriver(browserName);

        // Data
        firstName = "Trent";
        lastName = "Hoang";
        emailAdress = "Trent" + generateRandomNumber() + "@gmail.com";
        passWord = "Trent@12345";
        adminUserName = "thaithuan";
        adminPassword = "anh7deptrai@";

        // Page ảo được sinh ra và bắt đầu làm những action của page ảo đó
        userHomePage = new UserHomePO(driver);

        // Pre-condition
        userHomePage.clickToAccountMenu();
        userHomePage.openRegisterPage();
//
//        // Từ homepage qua register page
//        // Page đó sinh ra và bắt đầu hành động làm những action của page đó -> khởi tạo = new lên
        userRegisterPage = new UserRegisterPO(driver);
        userRegisterPage.enterToFirstNameTextBox(firstName);
        userRegisterPage.enterToLastNameTextBox(lastName);
        userRegisterPage.enterToEmailTextBox(emailAdress);
        userRegisterPage.enterToPasswordTextBox(passWord);
        userRegisterPage.enterToConfirmPasswordTextBox(passWord);
        userRegisterPage.clickToRegisterButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        userHomePage = new UserHomePO(driver);
        Assert.assertEquals(userHomePage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }

    // Testcases
    @Test
    public void User_01_User_Site_To_Admin_Site() {
        userHomePage.clickToAccountMenu();
        userHomePage.clickToLogoutLink();

        userHomePage.clickToAccountMenu();
        userHomePage.openLoginPage();

        userLoginPage = new UserLoginPO(driver);
        userLoginPage.enterToEmailTextbox(emailAdress);
        userLoginPage.enterToPasswordTextbox(passWord);
        userLoginPage.openMyAccountPage();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        userMyAccPage = new UserMyaccountPO(driver);
        Assert.assertTrue(userMyAccPage.isHelloTextDisplayed());

        // step to order a product
        // ...
        // Redirect to Admin site to verify that ordered with admin role
        userHomePage.openPageURL(driver, adminUrlValue);


        // nếu chưa login thì khởi tạo trang login lên
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        // thao tác với trang admin ( vì khác với link web bài học nên chỉ làm những gì làm được)
        adminLoginPage.enterToUserNameTextbox(adminUserName);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminLoginPage.clickToLoginBtn();
        Assert.assertEquals(adminLoginPage.getErrorMessage(), "You did not sign in correctly or your account is temporarily disabled.");

        // nếu đã login trước đó rồi sau đó trở về user sau đó tiếp tục trở lại admin thì khởi tạo màn dashboard
        // adminDashboardPage = PageGenerator.getAdminDashboardPage(driver);

    }

    @Test
    public void User_02_Admin_Site_To_User_Site() {
        // lúc này thì nó đag ở trang dashboard của admin rồi nè, thao tác gì đó nhưng mà link này hỏng có vô được
        // nên lược bỏ bớt (xem video bài học tham khảo hoi), làm thao tác quay về user là được
        // user01 - guru99com
        adminLoginPage.openPageURL(driver, userUrlValue);
        userHomePage = PageGenerator.getUserHomePage(driver);

    }


    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    // Vì web này ko có tài khoản để login vào admin nên chỉ demo tới verify đã chuyển link sang admin có element nào đó
    // chứ ko follow theo bài học được
}
