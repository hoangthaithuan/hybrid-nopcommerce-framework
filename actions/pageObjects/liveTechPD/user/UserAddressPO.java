package pageObjects.liveTechPD.user;

import org.openqa.selenium.WebDriver;

public class UserAddressPO extends UserSidebarPO {

    private WebDriver driver;

    public UserAddressPO(WebDriver driver) {
        // super để gọi đến constructor của thằng cha, vì thằng cha cũng khởi tạo constructor
        super(driver);
        this.driver = driver;
    }


}
