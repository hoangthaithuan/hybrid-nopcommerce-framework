package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyaccountPageUI;

public class MyaccountPageObject extends BasePage {

    private WebDriver driver;

    public MyaccountPageObject(WebDriver driver) {
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

    public String getValueOfAttribute() {
        waitForElementVisible(driver, MyaccountPageUI.EDIT_INFO_VAVLUE);
        return getElementAttribute(driver, MyaccountPageUI.EDIT_INFO_VAVLUE, "href");
    }

    public boolean isHelloTextDisplayed() {
        waitForElementVisible(driver, MyaccountPageUI.HELLO_TEXT);
        return isElementDisplayed(driver, MyaccountPageUI.HELLO_TEXT);
    }
}
