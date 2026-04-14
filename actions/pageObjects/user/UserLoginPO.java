package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.LoginPageUI;

public class UserLoginPO extends BasePage {

    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String passWord) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);

    }

    public UserMyaccountPO openMyAccountPage() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserMyAccountPage(driver);

    }
}
