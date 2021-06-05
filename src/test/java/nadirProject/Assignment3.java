package nadirProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
        WebElement passWord = driver.findElement(By.xpath("//input[@name='_password']"));
        userName.sendKeys("user30");
        passWord.sendKeys("UserUser123", Keys.ENTER);
    }

    @Test (priority = 2)
    public void fleetSelector() throws InterruptedException {
        WebElement fleetInfo = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleetInfo.click();

        WebElement vehicle = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        vehicle.click();

        Thread.sleep(1000);
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actual = driver.getTitle();

        Assert.assertEquals(actual,expectedTitle,"Show this message when it fail");
    }

    @Test (priority = 3)
    public void carInfo() throws InterruptedException {
        WebElement carInfo = driver.findElement(By.xpath("//tr[@class='grid-row row-click-action']"));
        carInfo.click();
        Thread.sleep(1000);

    }

    @Test (priority = 4)
    public void addEvent() throws InterruptedException {
        WebElement addEvent = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));
        addEvent.click();
        Thread.sleep(1000);

    }

    @Test (priority = 5)
    public void fillEvent() throws InterruptedException {
        WebElement addTextTitle = driver.findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{\"message\":" +
                "\"This value should not be blank.\",\"payload\":null},\"Length\":{\"maxMessage\":\"This value is too long." +
                " It should have {{ limit }} character or less.|This value is too long. It should have {{ limit }} characters" +
                " or less.\",\"minMessage\":\"This value is too short. It should have {{ limit }} character or more.|This value " +
                "is too short. It should have {{ limit }} characters or more.\",\"exactMessage\":\"This value should have exactly " +
                "{{ limit }} character.|This value should have exactly {{ limit }} characters.\",\"charsetMessage\":\"This value does " +
                "not match the expected {{ charset }} charset.\",\"max\":255,\"min\":null,\"charset\":\"UTF-8\",\"payload\":null}}']"));
        addTextTitle.sendKeys("Cybertek");
        Thread.sleep(3000);
        WebElement clickSave = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        clickSave.click();

    }

    @Test (priority = 6)
    public void resetSetting() {
        WebElement reset = driver.findElement(By.xpath("//i[@class='fa-refresh']"));
    }


}
