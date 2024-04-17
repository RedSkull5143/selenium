import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicDropDownMenu {
    WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDropDown() throws InterruptedException {
        webDriver.get("https://web-playground.ultralesson.com/");
        webDriver.manage().window().maximize();

        WebElement searchIcon=webDriver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/summary/span"));
        searchIcon.click();

        WebElement searchBox=webDriver.findElement(By.id("Search-In-Modal"));
        searchBox.sendKeys("dress");

        WebDriverWait webDriverWait=new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Search-In-Modal")));

        //retrieve all options
        List<WebElement> dynamicDropOptions=webDriver.findElements(By.id("Search-In-Modal"));

        for(WebElement dynamicOption:dynamicDropOptions){
            if(dynamicOption.getText().contains("Graphic Dress"));
            dynamicOption.click();
            break;
        }
        Thread.sleep(5000);


    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }

}
