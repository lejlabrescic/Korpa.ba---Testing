package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AddAddressTest {
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
    void testAddAddress() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a")).click();

        WebElement email = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[1]/input"));
        email.sendKeys("amila.causevic@stu.ibu.edu.ba");

        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/button")).click();

        WebElement password = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/div[2]/input"));
        password.sendKeys("testiramoprojekatza10");

        webDriver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/form/button")).click();

        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[3]/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/ul/li[4]/a")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        WebElement adresa = webDriver.findElement(
                By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/div[1]/div/input[1]"));

        adresa.sendKeys("Branislava Nušića, Novi Grad Sarajevo");
        Thread.sleep(1000);

        WebElement broj = webDriver
                .findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/div[2]/input"));

        broj.sendKeys("46");
        Thread.sleep(1000);

        WebElement sprat = webDriver
                .findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/div[3]/input"));
        sprat.sendKeys("4");
        Thread.sleep(1000);

        webDriver
                .findElement(By.xpath(
                        "/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/div[4]/div/div/div/label[1]"))
                .click();

        WebElement info = webDriver.findElement(
                By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/div[6]/textarea"));
        info.sendKeys("Hello :) ");
        Thread.sleep(1000);

        webDriver
                .findElement(
                        By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/div[7]/div/label[2]"))
                .click();
        webDriver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[3]/div/form/div[1]/div[3]/button[2]")).click();
        Thread.sleep(2000);
    }

}
