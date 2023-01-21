package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class BecomePartner {
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
    public void testBecomePartner() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("/html/body/section[5]/div/div/div/div[2]/div[1]/div/div[2]/div/a")).click();
        String title = webDriver.findElement(By.xpath("/html/body/section[1]/div[3]/div/div/div/div/h1")).getText();
        assertEquals("Postanite korpa partner", title);
        webDriver.findElement(By.xpath("/html/body/section[1]/div[3]/div/div/div/div/a")).click();
        WebElement nameOfCompany = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[1]/div/input"));
        nameOfCompany.sendKeys("FIN");
        WebElement email = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[2]/div/input"));
        email.sendKeys("meho.mehic@gmail.com");
        WebElement phoneNumber = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[3]/div/input"));
        phoneNumber.sendKeys("+4676555423");
        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[4]/div/textarea"));
        message.sendKeys(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                        + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
                        + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
                        + "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[5]/div/span/span[1]")).click();
        Thread.sleep(2000);
        WebElement town = webDriver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
        town.sendKeys("Sarajevo");
        Thread.sleep(1000);
        town.sendKeys(Keys.ARROW_DOWN);
        town.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[6]/button")).click();
    }

}
