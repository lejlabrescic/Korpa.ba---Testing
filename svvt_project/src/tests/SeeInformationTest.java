package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeeInformationTest {
    private static String baseUrl;
    private static WebDriver webDriver;

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
    void TestSeeInfo() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div[1]/ul/li[4]"))).click();
        webDriver
                .findElement(By.xpath(
                        "/html/body/section[3]/div[2]/div[4]/section[1]/div/div[3]/div/div/div[1]/div/div[9]/div/div/div[2]/div/h6/a"))
                .click();
        webDriver.findElement(By.xpath("/html/body/section[1]/div[3]/div/div/div[2]/div/button[3]")).click();
        Thread.sleep(5000);

        webDriver.close();
    }

}
