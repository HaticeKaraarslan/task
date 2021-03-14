package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver_v89.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
