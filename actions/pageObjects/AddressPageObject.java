package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class AddressPageObject extends SidebarPageObject {

    private WebDriver driver;

    public AddressPageObject (WebDriver driver) {
        // super để gọi đến constructor của thằng cha, vì thằng cha cũng khởi tạo constructor
        super(driver);
        this.driver = driver;
    }


}
