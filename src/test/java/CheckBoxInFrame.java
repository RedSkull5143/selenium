import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckBoxInFrame {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
    }

    @Test
    public void testCheckBoxInFrame() throws InterruptedException {
        webDriver.get("https://htmldog.com/examples/inputcheckboxes/");
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement selectFrame=webDriver.findElement(By.xpath("//*[@id=\"dexOutput\"]/div/samp/iframe"));
        wait.until(ExpectedConditions.visibilityOf(selectFrame));
        webDriver.switchTo().frame(selectFrame);

        List <WebElement> checkBoxes=webDriver.findElements(By.tagName("input"));
        for(WebElement checkbox: checkBoxes){
            checkbox.click();
            Thread.sleep(2000);
        }

        for(WebElement unCheckBox:checkBoxes){
            unCheckBox.click();
            Thread.sleep(2000);
        }
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
