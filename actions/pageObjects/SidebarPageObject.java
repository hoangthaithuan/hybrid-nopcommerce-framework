package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.SidebarUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, SidebarUI.ADDRESS_LINK);
        clickToElement(driver, SidebarUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);

    }
    public MyaccountPageObject openMyAccPage() {
        waitForElementClickable(driver, SidebarUI.MYACCOUNT_LINK);
        clickToElement(driver, SidebarUI.MYACCOUNT_LINK);
        return PageGenerator.getMyAccountPage(driver);
    }

    public ProdReviewsPageObject openProdReviewPage() {
        waitForElementClickable(driver, SidebarUI.PRODREVIEW_LINK);
        clickToElement(driver, SidebarUI.PRODREVIEW_LINK);
        return PageGenerator.getProdReviewPage(driver);
    }

    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver, SidebarUI.ORDER_LINK);
        clickToElement(driver, SidebarUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }
}
