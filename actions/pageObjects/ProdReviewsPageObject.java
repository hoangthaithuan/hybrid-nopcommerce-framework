package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProdReviewsPageUI;

public class ProdReviewsPageObject extends SidebarPageObject {

    private WebDriver driver;

    public ProdReviewsPageObject(WebDriver driver) {
        // super để gọi đến constructor của thằng cha, vì thằng cha cũng khởi tạo constructor
        super(driver);
        this.driver = driver;
    }


}
