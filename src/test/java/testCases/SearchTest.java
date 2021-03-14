package testCases;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import cucumber.api.java.gl.E;
import feature.page.LoginXpath;
import feature.page.SearchXpath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementUtil;

public class SearchTest {
    public WebDriver driver;
    static String loginPageUrl = "https://getir.com/yemek/";
    static String username = "5418066846";
    static String password = "Getir.123";
    static String search="Borek";


    LoginXpath xpath=new LoginXpath();
    SearchXpath searchXpath=new SearchXpath();
    ElementUtil elementUtil=new ElementUtil();

    @Given("^kullanici sisteme giris yapmistir$")
    public void giris()  {

        System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver_v89.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();        driver.get(loginPageUrl);
        driver.findElement(By.xpath(xpath.getLoginPassBtn())).click();
        driver.findElement(By.xpath(xpath.getNumber())).sendKeys(username);
        driver.findElement(By.xpath(xpath.getPassword())).sendKeys(password);
        driver.findElement(By.xpath(xpath.getLoginBtn())).click();

    }

    @When("^arama kismina börek yazar$")
    public void borekSearch() {
        elementUtil.javascriptClick(searchXpath.getSearch(),driver);
        driver.findElement(By.xpath(searchXpath.getSearch())).sendKeys("börek");
        elementUtil.javascriptClick(searchXpath.getSelect(),driver);

    }

    @And("^gelen börek combobox ina tiklar$")
    public void borekComboClick() {
        elementUtil.sleep(1500);
        elementUtil.javascriptClick(searchXpath.getSearchResult(),driver);

    }

    @Then("^arama islemi börek kategorisine göre oldugu control edilir$")
    public void borekControl() {

        WebElement element=driver.findElement(By.xpath("//*[@data-testid=\"tag\"]"));
        String control=element.getText();
        Assert.assertEquals(control, "Börek");

    }

    @When("^arama kisminda ödeme yöntemi nakit yazar$")
    public void nakitSearch() {

        elementUtil.javascriptClick(searchXpath.getOdemeYontemi(),driver);
        driver.findElement(By.xpath(searchXpath.getOdemeYontemi())).sendKeys("Nakit");

    }
    @And("^arama kisminda nakit radyo butonuna tiklanir$")
    public void nakitClick() {
        elementUtil.javascriptClick(searchXpath.getOdemeYontemiSelect(),driver);

    }

    @Then("^arama islemi nakit yonteme göre oldugu control edilir$")
    public void nakitFiltreControl() {

        WebElement element=driver.findElement(By.xpath(searchXpath.getOdemeYontemiControl()));
        String control=element.getText();
        Assert.assertEquals(control, "Nakit");

    }
    @When("^arama kismina cig kofte yazar$")
    public void kofteSearch() {
        elementUtil.javascriptClick(searchXpath.getSearch(),driver);
        driver.findElement(By.xpath(searchXpath.getSearch())).clear();
        driver.findElement(By.xpath(searchXpath.getSearch())).sendKeys("Çiğ Köfte");
        elementUtil.javascriptClick(searchXpath.getSelect(),driver);

    }

    @And("^gelen cig kofte combobox ina tiklar$")
    public void kofteComboClick() {
        elementUtil.sleep(1500);
        elementUtil.javascriptClick(searchXpath.getSearchResult(),driver);

    }

    @Then("^arama islemi cig kofte kategorisine göre oldugu control edilir$")
    public void kofteControl() {

        WebElement element=driver.findElement(By.xpath("(//*[@data-testid=\"tag\"])[1]"));
        String control=element.getText();
        Assert.assertEquals(control, "Çiğ Köfte");
        driver.close();

    }


}
