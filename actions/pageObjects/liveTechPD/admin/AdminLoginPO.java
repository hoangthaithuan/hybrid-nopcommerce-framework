package pageObjects.liveTechPD.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveTechPD.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {

    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToPasswordTextbox(String userName) {
        sendKeyToElement(driver, AdminLoginPageUI.USERNAME, userName);
    }

    public void enterToUserNameTextbox(String passWord) {
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD, passWord);
    }

    public void clickToLoginBtn() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementClickable(driver, AdminLoginPageUI.ERROR_MESSAGE);
        return getElementText(driver, AdminLoginPageUI.ERROR_MESSAGE);
    }
}
