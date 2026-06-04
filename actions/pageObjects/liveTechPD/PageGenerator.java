package pageObjects.liveTechPD;

import org.openqa.selenium.WebDriver;
import pageObjects.liveTechPD.admin.AdminLoginPO;
import pageObjects.liveTechPD.user.*;

public class PageGenerator {

    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserMyaccountPO getUserMyAccountPage(WebDriver driver) {
        return new UserMyaccountPO(driver);
    }

    public static UserAddressPO getUserAddressPage(WebDriver driver) {
        return new UserAddressPO(driver);
    }

    public static UserOrderPO getUserOrderPage(WebDriver driver) {
        return new UserOrderPO(driver);
    }

    public static UserProdReviewsPO getUserProdReviewPage(WebDriver driver) {
        return new UserProdReviewsPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }
}
