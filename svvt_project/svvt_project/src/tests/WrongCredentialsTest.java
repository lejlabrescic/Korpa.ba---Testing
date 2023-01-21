package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WrongCredentialsTest {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DT User\\Desktop\\chromedriver_wnew\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "https://www.korpa.ba/";
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        webDriver.quit();
    }

    @Test
    public void testWrongInput() throws InterruptedException {
        webDriver.get(baseUrl);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        WebElement register = webDriver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a"));
        js.executeScript("arguments[0].click()", register);
        webDriver.findElement(By.xpath("//*[@id=\"target\"]/div[2]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"inputFullName\"]")).sendKeys("Jane Doe");
        webDriver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("amila.causevic@stu.ibu.edu.ba");
        webDriver.findElement(By.xpath("//*[@id=\"inputPhone\"]")).sendKeys("0603483040");
        webDriver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("testiramoprojekatza10");
        webDriver.findElement(By.xpath("//*[@id=\"target\"]/button")).click();
        String taken_email = webDriver.findElement(By.xpath("//*[@id=\"target\"]/div[2]/span")).getText();
        assertTrue(taken_email.contains("Već zauzeto"));
        String taken_phone_number = webDriver.findElement(By.xpath("//*[@id=\"target\"]/div[3]/span")).getText();
        assertTrue(taken_phone_number.contains("Već zauzeto"));
        Thread.sleep(3000);

    }
}
