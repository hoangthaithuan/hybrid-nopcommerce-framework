package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.SidebarUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, SidebarUI.ADDRESS_LINK);
        clickToElement(driver, SidebarUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);

    }
    public UserMyaccountPO openMyAccPage() {
        waitForElementClickable(driver, SidebarUI.MYACCOUNT_LINK);
        clickToElement(driver, SidebarUI.MYACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }

    public UserProdReviewsPO openProdReviewPage() {
        waitForElementClickable(driver, SidebarUI.PRODREVIEW_LINK);
        clickToElement(driver, SidebarUI.PRODREVIEW_LINK);
        return PageGenerator.getUserProdReviewPage(driver);
    }

    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, SidebarUI.ORDER_LINK);
        clickToElement(driver, SidebarUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
}
