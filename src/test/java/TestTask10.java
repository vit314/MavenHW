import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestTask10 {

    WebDriver driver;

    @BeforeMethod
    public void setUpClass() {

        System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void testW3School () {

        driver.get("https://www.w3schools.com/");

        WebElement searchBtn = driver.findElement(By.id("navbtn_tutorials"));
        searchBtn.click();

        WebElement javaLink = driver.findElement(By.xpath("(//a[@class='w3-bar-item w3-button'][normalize-space()='Learn Java'])[1]"));
        javaLink.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Java Tutorial";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
