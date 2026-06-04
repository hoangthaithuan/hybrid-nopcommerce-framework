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

public class Level08_Table_Data extends BaseTest {

    @Parameters ({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }

    // Testcases
    //@Test
    public void Table_01_Paging() {
        // tạm thời chạy lỗi lúc lỗi lúc ko
        homePage.openPageNumber("7");
        Assert.assertTrue(homePage.isNumberActive("7"));

        homePage.openPageNumber("12");
        Assert.assertTrue(homePage.isNumberActive("12"));

        homePage.openPageNumber("1");
        Assert.assertTrue(homePage.isNumberActive("1"));
    }

    //@Test
    public void Table_02_Filter_Data() {
        // Enter value to textbox
        homePage.enterToTextBoxByHeaderName("Females", "384187");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("384187", "Afghanistan", "407124", "791312"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByHeaderName("Country", "Angola");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("276880", "Angola", "276472", "553353"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByHeaderName("Males", "803");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("777", "Antigua and Barbuda", "803", "1580"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByHeaderName("Total", "49397");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("24128", "Albania", "25266", "49397"));
        homePage.refreshCurrentPage(driver);
        // Verify data in any row
    }

    //@Test
    public void Table_03_Delete_Edit() {
        homePage.enterToTextBoxByHeaderName("Country", "Afghanistan");
        homePage.sleepInSecond(3);
        // remove
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        // edit
        homePage.enterToTextBoxByHeaderName("Country", "Angola");
        homePage.sleepInSecond(3);
        homePage.editRowByCountryName("Angola");
        homePage.refreshCurrentPage(driver);

    }

    @Test
    public void Table_04_Get_All_Value_Row_Or_Column() {
        homePage.getAllValueAtColumnName("Country");
    }

    //@Test
    public void Table_05_Action_By_Index() {
        // có thể thao tác với bất kỳ col/row nào
        homePage.openPageURL(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        homePage.clickToLoadDataButton();
        // video coi được  rồi

        homePage.enterToTextboxByIndex("7", "Contact Person", "Thai Thuan");

        homePage.enterToTextboxByIndex("5", "Company", "FA Entertainment");

        homePage.selectToDropdownByIndex("2", "Country", "Hong Kong");

        homePage.selectToDropdownByIndex("4", "Country", "Germany");

        homePage.checkToCheckboxByIndex("6", "NPO?", true);

        homePage.checkToCheckboxByIndex("5", "NPO?", false);

        homePage.clickToIconByIndex("8", "Move Up");
        homePage.clickToIconByIndex("6", "Remove");
        homePage.clickToIconByIndex("4", "Insert");

    }

    // Post-condition
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    private WebDriver driver;
    private HomePO homePage;
}
