import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RadioButton {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
    }

    @Test
    public void testRadioButton() throws InterruptedException {
        webDriver.get("https://demoqa.com/radio-button");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement yesBtn= webDriver.findElement(By.id("yesRadio"));
        yesBtn.click();
        Thread.sleep(2000);

        WebElement impressiveBtn= webDriver.findElement(By.id("impressiveRadio"));
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.close();
    }
}
