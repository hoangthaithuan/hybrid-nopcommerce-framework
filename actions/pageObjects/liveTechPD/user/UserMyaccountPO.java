package pageObjects.liveTechPD.user;

import org.openqa.selenium.WebDriver;
import pageUIs.liveTechPD.user.MyaccountPageUI;

public class UserMyaccountPO extends UserSidebarPO {

    private WebDriver driver;

    public UserMyaccountPO(WebDriver driver) {
        // super để gọi đến parameter của thằng cha, vì thằng cha cũng khởi tạo driver
        super(driver);
        this.driver = driver;
    }


    public boolean isTitleDisplayed() {
        /*
            vì sao lại cho return false
            -> nếu để true thì nó sẽ luôn pass mặc dù chưa làm j hết
        */
        waitForElementVisible(driver, MyaccountPageUI.MY_DASHBOARD_TEXT);
        return isElementDisplayed(driver, MyaccountPageUI.MY_DASHBOARD_TEXT);
    }
    public boolean isHelloTextDisplayed() {
        waitForElementVisible(driver, MyaccountPageUI.HELLO_TEXT);
        return isElementDisplayed(driver, MyaccountPageUI.HELLO_TEXT);
    }

    public String getValueOfAttribute() {
        waitForElementVisible(driver, MyaccountPageUI.EDIT_INFO_VAVLUE);
        return getElementAttribute(driver, MyaccountPageUI.EDIT_INFO_VAVLUE, "href");
    }


}
