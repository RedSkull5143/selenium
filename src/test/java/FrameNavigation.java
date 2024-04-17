import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameNavigation {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void frameNavigation(){
        webDriver.get("https://demo.automationtesting.in/Frames.html");
        webDriver.manage().window().maximize();
        WebElement frame=webDriver.findElement(By.id("singleframe"));
        webDriver.switchTo().frame(frame);
        WebElement inputBox=webDriver.findElement(By.xpath("/html/body/section/div/div/div/input"));
        inputBox.sendKeys("Om Shinde");
        System.out.println(webDriver.getCurrentUrl());
        webDriver.switchTo().defaultContent();
        System.out.println(webDriver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
