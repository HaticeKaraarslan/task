package testCases;

import config.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import feature.page.LoginXpath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public WebDriver driver;
    static String loginPageUrl = "https://getir.com/yemek/";
    static String username = "5418066846";
    static String password = "Getir.123";


    LoginXpath xpath=new LoginXpath();

    @Given("^I am going to the login page$")
    public void iAmGoingToTheLoginPage() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver_v89.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();        driver.get(loginPageUrl);
        driver.findElement(By.xpath(xpath.getLoginPassBtn())).click();

    }

    @When("^kadi ve sifre girilir$")
    public void kAdiVeSifreGirilir() {
        driver.findElement(By.xpath(xpath.getNumber())).sendKeys(username);
        driver.findElement(By.xpath(xpath.getPassword())).sendKeys(password);

    }

    @And("^giris butonuna tiklanir$")
    public void girisButonunaTiklanir() {
        driver.findElement(By.xpath(xpath.getLoginBtn())).click();    }

    @Then("^anasayfanin geldigi görülür$")
    public void anasayfanınGeldiğiGörülür() {
        Assert.assertEquals(driver.getTitle(), "GetirYemek - Yemek siparişi artık Getir farkıyla! | GetirYemek");
        driver.close();

    }


}
