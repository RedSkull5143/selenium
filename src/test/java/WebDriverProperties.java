import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverProperties {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
    }

    @Test(description = "Checking WebDriver Properties")
    public void propertiesTest(){
        webDriver.get("https://web-playground.ultralesson.com/");
        webDriver.manage().window().maximize();
        String cUrl=webDriver.getCurrentUrl();
        System.out.println("URL : "+cUrl);

        String title=webDriver.getTitle();
        System.out.println("Title : "+title);

        WebElement titleEle= webDriver.findElement(By.xpath("//span[@class='h2']"));
        System.out.println("Element Name : "+titleEle.getText());
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
