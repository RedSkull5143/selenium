import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
    }

    @Test
    public void testDropDown() throws InterruptedException {
        webDriver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        webDriver.manage().window().maximize();

        WebDriverWait waitForTextToChange=new WebDriverWait(webDriver,Duration.ofSeconds(12));
        WebElement changeTextButton=webDriver.findElement(By.id("populate-text"));
        waitForTextToChange.until(ExpectedConditions.textToBe(By.id("h2"),"site"));

        WebDriverWait waitForElementToDisplay = new WebDriverWait(webDriver, Duration.ofSeconds(13));
        WebElement displayButton = webDriver.findElement(By.id("display-other-button"));
        displayButton.click();
        waitForElementToDisplay.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));

        WebDriverWait waitForElementEnabled = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement enableButton = webDriver.findElement(By.id("enable-button"));
        enableButton.click();
        waitForElementEnabled.until(ExpectedConditions.elementToBeClickable(By.id("disable")));

        WebDriverWait waitForElementToBeChecked = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement checkboxButton = webDriver.findElement(By.id("checkbox"));
        checkboxButton.click();
        waitForElementToBeChecked.until(ExpectedConditions.elementSelectionStateToBe(By.id("ch"), true));

    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
