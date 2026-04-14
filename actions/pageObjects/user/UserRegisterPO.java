package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.RegisterPageUI;

public class UserRegisterPO extends BasePage {

    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextBox(String firstName) {
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextBox(String emailAddress) {
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String passWord) {
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);
    }

    public void enterToConfirmPasswordTextBox(String confirmPass) {
        sendKeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPass);
    }

    public UserHomePO clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
}
