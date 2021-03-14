package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

    public void javascriptClick(String xpath, WebDriver driver) {
        By by = By.xpath(xpath);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement e =new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));


        try {
            executor.executeScript("arguments[0].click();", e);

        } catch (Exception ex) {
//            LogUtil.assertFail(xpath + " JS click failed !\n" + ex.getMessage());
        }
        sleep(1000);
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
