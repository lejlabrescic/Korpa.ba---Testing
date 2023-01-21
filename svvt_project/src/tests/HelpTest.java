package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class HelpTest {
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
        webDriver.close();
    }

    @Test
    void testHelp() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();

        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a")).click();
        Thread.sleep(2000);

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
        webDriver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div[3]/div[1]/a")).click();

        WebElement imeprezime = webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/div/section/form/div[1]/div/input"));
        imeprezime.sendKeys("Amila Causevic");

        WebElement emailp = webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/div/section/form/div[2]/div/input"));
        emailp.sendKeys("amila.causevic@stu.ibu.edu.ba");

        WebElement broj = webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/div/section/form/div[3]/div/input"));
        broj.sendKeys("062665469");

        WebElement text = webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/div/section/form/div[4]/div/textarea"));
        text.sendKeys("Test testic necemo slati<3");

        webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/div/section/form/div[5]/button"));
        Thread.sleep(3000);

    }

}
