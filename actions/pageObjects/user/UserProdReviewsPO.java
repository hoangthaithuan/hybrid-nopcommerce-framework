package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class UserProdReviewsPO extends UserSidebarPO {

    private WebDriver driver;

    public UserProdReviewsPO(WebDriver driver) {
        // super để gọi đến constructor của thằng cha, vì thằng cha cũng khởi tạo constructor
        super(driver);
        this.driver = driver;
    }


}
