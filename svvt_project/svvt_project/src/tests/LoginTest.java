package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
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

    void testLogin() throws InterruptedException {
        webDriver.get(baseUrl);
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
    }
}
