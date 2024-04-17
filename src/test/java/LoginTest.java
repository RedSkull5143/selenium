import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
////a[@class='menu-drawer__account link focus-inset h5']
    @Test
    public void testLogin() throws InterruptedException {
        webDriver.get("https://web-playground.ultralesson.com/");
        webDriver.manage().window().maximize();
        WebElement loginBtn= webDriver.findElement(By.linkText("Log in"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement emailTextBox=webDriver.findElement(By.id("CustomerEmail"));
        emailTextBox.sendKeys("omshinde5143@gmail.com");
        Thread.sleep(2000);
        WebElement passwordTextBox=webDriver.findElement(By.id("CustomerPassword"));
        passwordTextBox.sendKeys("OmShinde@1234");
        Thread.sleep(2000);
        WebElement signInBtn=webDriver.findElement(By.xpath("//input[@id='CustomerPassword']//parent::div//following-sibling::button"));
        signInBtn.click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }

}
