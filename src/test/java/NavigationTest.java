import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigationTest {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openBrowserTest() throws InterruptedException {
        webDriver.get("https://www.google.com");
        webDriver.manage().window().maximize();
        WebElement element = webDriver.findElement(By.xpath("//textarea[@title='Search']"));
        element.sendKeys("Ultralessons");
        element.submit();
        Thread.sleep(5000);
        webDriver.navigate().back();
        Thread.sleep(2000);
        webDriver.navigate().forward();
        Thread.sleep(2000);
        webDriver.navigate().back();
        Thread.sleep(2000);
        webDriver.navigate().refresh();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
