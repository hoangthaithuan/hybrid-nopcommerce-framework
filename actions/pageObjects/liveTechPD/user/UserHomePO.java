package pageObjects.liveTechPD.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveTechPD.PageGenerator;
import pageUIs.liveTechPD.user.HomePageUI;

public class UserHomePO extends BasePage {

    private WebDriver driver;

    // Hàm khởi tạo (Constructor function)
    // 1- hàm cùng tên với class
    // 2- Không có kiểu trả về
    // 3- Chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4- Có tham số hoặc không
    // 5- ko tự define hàm khởi tạo thì JVM sẽ mặc định tạo ra 1 hàm
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToAccountMenu() {
        waitForElementClickable(driver, HomePageUI.ACCOUNTMENU_LINK);
        clickToElement(driver, HomePageUI.ACCOUNTMENU_LINK);
    }

    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, HomePageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, HomePageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

}
