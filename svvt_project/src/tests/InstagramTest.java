package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class InstagramTest {
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
    public void testInstagram() throws InterruptedException {
        webDriver.get(baseUrl);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        js.executeScript("arguments[0].scrollIntoView(true)",
                webDriver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")));
        WebElement instagram = webDriver.findElement(By.xpath("//*[@id=\"share\"]/a[2]"));

        String handle1 = webDriver.getWindowHandle();
        js.executeScript("arguments[0].click()", instagram);
        for (String handle : webDriver.getWindowHandles()) {
            if (!handle.equals(handle1)) {
                webDriver.switchTo().window(handle);
                break;
            }
        }
        webDriver.findElement(By.xpath(
                "//*[@id=\"mount_0_0_Kq\"]/div/div/div/div[1]/div/div/div/div[1]/section/nav/div[2]/div/div/div[3]/div/div[1]/div/div/div/div[3]/div[1]/a"))
                .click();
        String profile_name = webDriver
                .findElement(By
                        .xpath("//*[@id=\"mount_0_0_58\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/header/section/div[1]/h2"))
                .getText();
        assertEquals("korpa.ba", profile_name);
        String caption = webDriver.findElement(By.xpath(
                "//*[@id=\"mount_0_0_L8\"]/div/div/div/div[1]/div/div/div/div[1]/section/nav/div[2]/div/div/div[3]/div/div/div[1]/a/button"))
                .getText();
        assertEquals(caption.length(), 149);

        webDriver.close();
        webDriver.switchTo().window(handle1);
    }

}
