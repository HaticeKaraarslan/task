package testCases;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import feature.page.LoginXpath;
import feature.page.SearchXpath;
import feature.page.ShoppingXpath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ElementUtil;

public class ShoppingTest {

    public WebDriver driver;
    static String loginPageUrl = "https://getir.com/yemek/";
    static String username = "5418066846";
    static String password = "Getir.123";
    static String search="Borek";


    LoginXpath xpath=new LoginXpath();
    SearchXpath searchXpath=new SearchXpath();
    ShoppingXpath shoppingXpath=new ShoppingXpath();
    ElementUtil elementUtil=new ElementUtil();

    @Given("^kullanici sisteme basariyla giris yapmistir$")
    public void giris()  {

        System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver_v89.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();        driver.get(loginPageUrl);
        driver.findElement(By.xpath(xpath.getLoginPassBtn())).click();
        driver.findElement(By.xpath(xpath.getNumber())).sendKeys(username);
        driver.findElement(By.xpath(xpath.getPassword())).sendKeys(password);
        driver.findElement(By.xpath(xpath.getLoginBtn())).click();

    }

    @When("^arama kismina döner yazar$")
    public void donerSearch() {
        elementUtil.javascriptClick(searchXpath.getSearch(),driver);
        driver.findElement(By.xpath(searchXpath.getSearch())).sendKeys("döner");
        elementUtil.javascriptClick(searchXpath.getSelect(),driver);

    }

    @And("^gelen döner combobox ina tiklar$")
    public void donerComboClick() {
        elementUtil.sleep(1500);
        elementUtil.javascriptClick(searchXpath.getSearchResult(),driver);

    }

    @And("^arama islemi döner kategorisine göre oldugu control edilir$")
    public void donerControl() {

        WebElement element=driver.findElement(By.xpath("//*[@data-testid=\"tag\"]"));
        String control=element.getText();
        Assert.assertEquals(control, "Döner");

    }

    @And("^kullanici gelen arama sayfasinda döner tiklar$")
    public void donerLinkClick() {
        elementUtil.javascriptClick(shoppingXpath.getSelect(),driver);



    }
    @And("^kullanici yemek sepetine ekler$")
    public void donerAdd() {
        elementUtil.sleep(1500);
        elementUtil.javascriptClick(shoppingXpath.getAddBtn(),driver);
        if (!driver.findElements(By.xpath("(//*[text()='Soğansız']//..//..//span)[2]")).isEmpty()){
            elementUtil.javascriptClick("(//*[text()='Soğansız']//..//..//span)[2]",driver);
        }

        elementUtil.javascriptClick(shoppingXpath.getPopupBtn(),driver);



    }
    @And("^kullanici sepetini bosaltir$")
    public void basketBosalt() {
        elementUtil.javascriptClick(shoppingXpath.getBagIcon(),driver);
        elementUtil.javascriptClick(shoppingXpath.getDeleteIcon(),driver);
        elementUtil.javascriptClick(shoppingXpath.getPopupDeleteBtn(),driver);



    }
    @Then("^sepetin bosaltildigi kontrol edilir$")
    public void basketControl() {

        driver.close();



    }

}
