package pageUIs.user;

public class HomePageUI {
    /*
            - Biến non-static và non-final: public String loginLink = "abc";
            -> cho phép thay đổi giá trị -> ko nên làm thế khi code

            - Biến non-static: public final String loginLink ="abc";
            -> phải tạo đối tượng hoặc kế thừa mới dùng được

            - Biến static final: được quy ước là HẰNG SỐ luôn
            public static final String REGISTER_LINK = "ABC";

            - public: gọi hàm/ biến ra sử dụng luôn bình thường
            - private/default: khác package ko dùng được
            - protected: các class bên PO ko kế thừa bên PUI nên ko áp dụng
            - static: cho phép gọi trực tiếp từ class
            - final: ngăn chặn việc sửa chữa, update lại giá trị trong quá trình run
            - String: vì tất cả By Locator đều nhận vào String
            - REGISTER_LINK: convention đặt tên cho hằng số thì in hoa hết
     */

    public static final String ACCOUNTMENU_LINK = "//a[contains(@class,'skip-account')]/span[text()='Account']";

    public static final String REGISTER_LINK = "//a[@title='Register']";

    public static final String REGISTER_SUCCESS_MESSAGE = "//li[@class='success-msg']//li/span";

    public static final String LOGOUT_LINK = "//a[@title='Log Out']";

    public static final String LOGIN_LINK = "//a[@title='Log In']";




}
