package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class UserOrderPO extends UserSidebarPO {

    private WebDriver driver;

    public UserOrderPO(WebDriver driver) {
        // super để gọi đến constructor của thằng cha, vì thằng cha cũng khởi tạo constructor
        super(driver);
        this.driver = driver;
    }


}
