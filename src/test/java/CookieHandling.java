import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CookieHandling {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void cookieHandling(){
        webDriver.get("https://www.google.com");
        Cookie cookie=new Cookie("om","1");
        Cookie cookie1=new Cookie("hri","2");
        webDriver.manage().addCookie(cookie);
        webDriver.manage().addCookie(cookie1);

        //print
        Cookie readCookie=webDriver.manage().getCookieNamed("om");
        Cookie readCookie1=webDriver.manage().getCookieNamed("hri");
        System.out.println(readCookie);
        System.out.println(readCookie1);

        webDriver.manage().deleteCookie(cookie1);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
