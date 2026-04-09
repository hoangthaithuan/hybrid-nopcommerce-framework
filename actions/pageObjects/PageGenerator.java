package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static HomePageObject getHomePage (WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage (WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage (WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static MyaccountPageObject getMyAccountPage (WebDriver driver) {
        return new MyaccountPageObject(driver);
    }

    public static AddressPageObject getAddressPage (WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static OrderPageObject getOrderPage (WebDriver driver) {
        return new OrderPageObject(driver);
    }

    public static ProdReviewsPageObject getProdReviewPage (WebDriver driver) {
        return new ProdReviewsPageObject(driver);
    }
}
