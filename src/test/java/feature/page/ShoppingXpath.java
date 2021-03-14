package feature.page;

public class ShoppingXpath {

    private final String select = "(//*[@data-testid=\"paragraph\"])[2]";
    private final String addBtn = "//*[@kind=\"primary\"]//*[@data-testid=\"button\"]";
    private final String popupBtn = "//*[@kind=\"primary\"]//*[text()='Sepete Ekle']";
    private final String bagIcon = "//*[@name=\"bag\"]//..";
    private final String bagControl = "(//article[contains(@class, 'style__Basket')]//*[@data-testid=\"text\"])[3]";
    private final String deleteIcon = "//*[@name=\"delete-1\"]//..";
    private final String popupDeleteBtn = "//button[text()='Evet']";

    public String getSelect() {
        return select;
    }

    public String getAddBtn() {
        return addBtn;
    }

    public String getPopupBtn() {
        return popupBtn;
    }

    public String getBagIcon() {
        return bagIcon;
    }

    public String getBagControl() {
        return bagControl;
    }

    public String getDeleteIcon() {
        return deleteIcon;
    }

    public String getPopupDeleteBtn() {
        return popupDeleteBtn;
    }
}
