package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class MyProfileTest {
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
    public void testMyProfile() throws InterruptedException {

        webDriver.get("https://korpa.ba/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a")).click();

        WebElement email = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/input"));
        email.sendKeys("amila.causevic@stu.ibu.edu.ba");
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/button")).click();
        Thread.sleep(2000);

        WebElement password = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/input"));
        password.sendKeys("testiramoprojekatza10");
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/button")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[3]/a")).click();

        webDriver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/div/div/div/p[3]/a")).click();
        Thread.sleep(2000);

        WebElement name = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div/div[1]/input"));
        name.clear();
        name.sendKeys("Lejla i Amila <3");
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]")).click();
        Thread.sleep(2000);

    }

}
