package nadirProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Assignment3 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }
    @AfterClass
    public void teardown(){
        //driver.close();
    }

    @Test (priority = 1)
    public void logIn(){
        WebElement userName = driver.findElement(By.xpath("//input[@name='_username']"));
        userName.sendKeys("user30");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='_password']"));
        passWord.sendKeys("UserUser123", Keys.ENTER);
    }

    @Test (priority = 2)
    public void fleetSelector(){
        WebElement fleetInfo = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleetInfo.click();
        WebElement vehicle = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        vehicle.click();
    }



}
