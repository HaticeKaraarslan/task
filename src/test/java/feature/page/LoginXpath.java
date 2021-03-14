package feature.page;


public class LoginXpath {

    private String loginPassBtn = "//*[contains(@class, 'style__LoginWithGetir')]";
    private String number = "(//*[@placeholder='Telefon Numarası'])[2]";
    private String password = "//*[@name=\"password\"]";
    private String loginBtn = "(//*[text()='Giriş yap'])[2]";
    private String errorMessage = "//*[contains(@class, 'style__FormErrorMessage')]";
    private String loginControl = "//*[@placeholder=\"Yemek veya restoran ara\"]";

    public String getLoginPassBtn() {
        return loginPassBtn;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getLoginBtn() {
        return loginBtn;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getLoginControl() {
        return loginControl;
    }
}
