package pageObjects.liveTechPD.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveTechPD.PageGenerator;
import pageUIs.liveTechPD.user.SidebarUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }


    // các hàm này đều giống nhau chỉ khác về locator
    // vậy nên cần tối ưu ta chỉ cần viết một hàm
    // và dùng String format (%s) để thay thế chuỗi cần truyền
    // cách này phù hợp cho ít page vì nếu nhiều page thì cũng nhiều case theo, code dài
    public UserSidebarPO openSidebarLinkByPageName(String pageName) {
        waitForElementClickable(driver, SidebarUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, SidebarUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

        switch (pageName) {
            case "Address Book":
                return PageGenerator.getUserAddressPage(driver);
            case "My Orders":
                return PageGenerator.getUserOrderPage(driver);
            case "My Product Reviews":
                return PageGenerator.getUserProdReviewPage(driver);
            case "Account Dashboard":
                return PageGenerator.getUserMyAccountPage(driver);
            default:
                throw new RuntimeException("Page name is not valid!!!");
        }
    }

    // cách này áp dụng cho cả nhiều và ít page
    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, SidebarUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, SidebarUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

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
