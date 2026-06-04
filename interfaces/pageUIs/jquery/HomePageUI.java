package pageUIs.jquery;

public class HomePageUI {
//    public static final String PAGE_NUMBER = "xpath=//a[text()='%s']";
//    public static final String DYNAMIC_PAGE_LINK = "xpath=//a[text()='%s']/parent::li";

    public static final String PAGE_NUMBER = "xpath=//a[contains(@class,'qgrd-pagination-page-link') and text()='%s']";

    public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::" +
            "td[@data-key='country' and text()='%s']/following-sibling::" +
            "td[@data-key='males' and text()='%s']/following-sibling::" +
            "td[@data-key='total' and text()='%s']";

    public static final String DYNAMIC_REMOVE_BTN_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/" +
            "preceding-sibling::td[@class='qgrd-actions']/button[contains(@class, 'remove')]";

    public static final String DYNAMIC_EDIT_BTN_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/" +
            "preceding-sibling::td[@class='qgrd-actions']/button[contains(@class, 'edit')]";

    //
    public static final String LOAD_DATA_BUTTON = "css=button#load";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_SELECT_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";
    public static final String DYNAMIC_ACTION_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td//button[contains(@title,'%s')]";

    //
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2 = "xpath=//div[text()='Country']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//td[%s]";

    //
    public static final String FILE_LOADED = "xpath=//p[@class='name' and text()='%s']";
    public static final String UPLOAD_BUTTON = "css=table button.start";
    public static final String FILE_LOADED_SUCCESS = "xpath=//p[@class='name']/a[@title='%s']";


}
