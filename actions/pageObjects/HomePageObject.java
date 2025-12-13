package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

    private WebDriver driver;

    // Hàm khởi tạo (Constructor function)
    // 1- hàm cùng tên với class
    // 2- Không có kiểu trả về
    // 3- Chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4- Có tham số hoặc không
    // 5- ko tự define hàm khởi tạo thì JVM sẽ mặc định tạo ra 1 hàm
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToAccountMenu() {
        waitForElementClickable(driver, HomePageUI.ACCOUNTMENU_LINK);
        clickToElement(driver, HomePageUI.ACCOUNTMENU_LINK);
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, HomePageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, HomePageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }
}
