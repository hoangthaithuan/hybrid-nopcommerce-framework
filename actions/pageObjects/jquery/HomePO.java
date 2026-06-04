package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }


// hàm của TABLE
    public void openPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
        sleepInSecond(2);
        System.out.println("Đã bấm á á");
    }


    public boolean isNumberActive(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGE_NUMBER, pageNumber);
        return getElementAttribute(driver, HomePageUI.PAGE_NUMBER, "class", pageNumber)
                .contains("active");
    }


    public void enterToTextBoxByHeaderName(String headerName, String valueToSendKey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,valueToSendKey, headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
    }

    public boolean isRowDataValueDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, females, country, males, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, females, country, males, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_REMOVE_BTN_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_REMOVE_BTN_BY_COUNTRY_NAME, countryName);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BTN_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BTN_BY_COUNTRY_NAME, countryName);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        // từ column name làm sao để lấy được column index
        // tìm số phần tử trước nó rồi +1 là ra vị trí của nó
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        // Convert nó qua dạng text(String)
        String columnIndex = String.valueOf(columnIndexNumber);

        // Truyền 2 giá trị rowIndex/columnIndex vào locator để tương taác/sendkey
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        // từ column name làm sao để lấy được column index
        // tìm số phần tử trước nó rồi +1 là ra vị trí của nó
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        // Convert nó qua dạng text(String)
        String columnIndex = String.valueOf(columnIndexNumber);

        // Truyền 2 giá trị rowIndex/columnIndex vào locator để tương taác/sendkey
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_SELECT_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        // từ column name làm sao để lấy được column index
        // tìm số phần tử trước nó rồi +1 là ra vị trí của nó
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        // Convert nó qua dạng text(String)
        String columnIndex = String.valueOf(columnIndexNumber);

        // Truyền 2 giá trị rowIndex/columnIndex vào locator để tương taác/sendkey
        if(checkOrUncheck) {
            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            unCheckToCheckbox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ACTION_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ACTION_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
    }

    public List<String> getAllValueAtColumnName(String columnName) {
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2, columnName).size() + 1;

        // Convert nó qua dạng text(String)
        String columnIndex = String.valueOf(columnIndexNumber);
        List<WebElement> allElementValueAtColumn = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, columnIndex);

        List<String> allTextValue = new ArrayList<String>();

        for (WebElement element : allElementValueAtColumn) {
            allTextValue.add(element.getText());
        }

        System.out.println(allTextValue);
        return allTextValue;
    }


    // Hàm của UPLOAD FILE

    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADED, fileName);
    }

    public void clickToUploadButton(WebDriver driver) {
        List<WebElement> uploadButton = getListElement(driver, HomePageUI.UPLOAD_BUTTON);
        for (WebElement button : uploadButton) {
            button.click();
            sleepInSecond(5);
        }
    }

    public boolean isFileLoadedSuccessByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED_SUCCESS, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADED_SUCCESS, fileName);
    }


}
