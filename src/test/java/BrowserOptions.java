import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserOptions {
    WebDriver webDriver;
    ChromeOptions options= new ChromeOptions();

    @BeforeMethod
    public void setUp(){
        options.addArguments("--incognito");
        webDriver=new ChromeDriver(options);
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
