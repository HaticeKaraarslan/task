package feature.page;

public class SearchXpath {

    private final String search = "//*[@placeholder=\"Mutfak türü ara\"]";
    private final String searchResult = "(//*[@data-testid=\"link\"])[2]";
    private final String select = "//*[@name=\"id\"]";
    private final String odemeYontemi = "//*[@placeholder=\"Ödeme yöntemi ara\"]";
    private final String odemeYontemiSelect = "//*[text()='Nakit']//..//..//*[@class=\"style__RadioBox-kjjl1a-1 eYeytv\"]";
    private final String odemeYontemiControl = "(//*[@data-testid=\"tag\"])[2]";

    public String getSearch() {
        return search;
    }

    public String getSearchResult() {
        return searchResult;
    }

    public String getSelect() {
        return select;
    }

    public String getOdemeYontemi() {
        return odemeYontemi;
    }

    public String getOdemeYontemiSelect() {
        return odemeYontemiSelect;
    }

    public String getOdemeYontemiControl() {
        return odemeYontemiControl;
    }
}
