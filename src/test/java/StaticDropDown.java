import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StaticDropDown {
    WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDropDown() throws InterruptedException {
        webDriver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        webDriver.manage().window().maximize();
        WebElement dropdownEle=webDriver.findElement(By.xpath("//div[@class='information closable']//parent::div//select"));
        Select dropdown=new Select(dropdownEle);

        //by visible text
        dropdown.selectByVisibleText("India");
        Thread.sleep(3000);

        //by value
        dropdown.selectByValue("USA");
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
