package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class RegistrationTest {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DT User\\Desktop\\chromedriver_wnew\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "https://www.korpa.ba/";
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        webDriver.quit();
    }

    @Test
    void testRegistration() throws InterruptedException {
        webDriver.get("https://korpa.ba/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a")).click();
        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/a")).click();

        WebElement name = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/input"));
        name.sendKeys("Amila");
        Thread.sleep(1000);

        WebElement email = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/input"));
        email.sendKeys("amila.causevic@stu.ibu.edu.ba");
        Thread.sleep(1000);

        WebElement number = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[3]/input"));
        number.sendKeys("061835427");
        Thread.sleep(1000);

        WebElement password = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[4]/input"));
        password.sendKeys("testiramoprojekatza10");
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/button")).click();
        Thread.sleep(5000);

    }

}
