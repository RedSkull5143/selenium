
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
    }

    @Test
    public void openBrowserTest() throws InterruptedException {
        webDriver.get("https://www.google.com");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
