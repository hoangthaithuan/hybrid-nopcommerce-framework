package com.livetechpanda.jquerycases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level09_Upload extends BaseTest {

    @Parameters ({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }

    // Testcases
    @Test
    public void Upload_01_() {
        // Lấy ra đường dẫn cuả file/thư mục cho đúng
        // Tất cả OS: window/mac/linux đều chạy được
        // upload 1 hoặc nhiều file => 1 hàm
//        homePage.uploadMultipleFiles(driver, airFile);
//        homePage.sleepInSecond(3);
        // có thể verify 1 hoặc nhiều file => 1 hàm
        homePage.uploadMultipleFiles(driver, airFile, rainstarFile, uniFile);
        homePage.sleepInSecond(3);

        // Verify upload file
        Assert.assertTrue(homePage.isFileLoadedByName(airFile));
        Assert.assertTrue(homePage.isFileLoadedByName(rainstarFile));
        Assert.assertTrue(homePage.isFileLoadedByName(uniFile));
        // click upload button
        homePage.clickToUploadButton(driver);
        // Verify file đã load xog
        Assert.assertTrue(homePage.isFileLoadedSuccessByName(airFile));
        Assert.assertTrue(homePage.isFileLoadedSuccessByName(rainstarFile));
        Assert.assertTrue(homePage.isFileLoadedSuccessByName(uniFile));

    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private WebDriver driver;
    private HomePO homePage;
    String airFile = "air.jpg";
    String rainstarFile = "rainstar.jpg";
    String uniFile = "uni.jpg";
}
