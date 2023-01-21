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

class FacebookTest {
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
    public void testFacebook() throws InterruptedException {
        webDriver.get(baseUrl);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        js.executeScript("arguments[0].scrollIntoView(true)",
                webDriver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")));
        WebElement facebook_button = webDriver.findElement(By.xpath("//*[@id=\"share\"]/a[1]"));

        String handle1 = webDriver.getWindowHandle();
        js.executeScript("arguments[0].click()", facebook_button);
        for (String handle : webDriver.getWindowHandles()) {
            if (!handle.equals(handle1)) {
                webDriver.switchTo().window(handle);
                break;
            }

        }
        String likes = webDriver.findElement(By.xpath(
                "//*[@id=\"mount_0_0_Cm\"]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[4]/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div/div[2]/div/div/span/span[1]"))
                .getText();
        assertTrue(likes.contains("15.194"));
        webDriver.close();
        webDriver.switchTo().window(handle1);
        Thread.sleep(3000);

    }

}
