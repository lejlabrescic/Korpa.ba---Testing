package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class WrongCredentials2 {
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
    public void testLoginCredentials() throws InterruptedException {
        webDriver.get(baseUrl);

        webDriver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("amila.causevic@stu.ibu.edu.ba");
        webDriver.findElement(By.xpath("//*[@id=\"target\"]/button")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("passw");
        webDriver.findElement(By.xpath("//*[@id=\"target\"]/button")).click();
        Thread.sleep(3000);
        String wrongPassword = webDriver.findElement(By.xpath("//*[@id=\"target\"]/div[1]")).getText();
        assertTrue(wrongPassword.contains("Netačna šifra"));
        String page = webDriver.getCurrentUrl();
        assertEquals("https://www.korpa.ba/login", page);
        Thread.sleep(2000);

    }

}
