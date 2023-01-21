package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestGooglePlay {
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
    public void testGooglePlay() throws InterruptedException {
        webDriver.get(baseUrl);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        js.executeScript("arguments[0].scrollIntoView(true)",
                webDriver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")));
        String handle1 = webDriver.getWindowHandle();
        js.executeScript("arguments[0].click()", webDriver.findElement(By.xpath("/html/body/footer/div/div/div[1]/div/a[1]")));
        for (String handle : webDriver.getWindowHandles()) {
            if (!handle.equals(handle1)) {
                webDriver.switchTo().window(handle);
                break;
            }

        }
        String rating = webDriver.findElement(By.xpath(
                "//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div[1]/div[2]/div/div[1]/c-wiz[4]/section/div/div/div[1]/div/div/div[1]/div[1]"))
                .getText();
        assertTrue(rating.contains("4.4"));
        js.executeScript("arguments[0].scrollIntoView(true)",
                webDriver.findElement(By.xpath("//*[@id=\\\"yDmH0d\\\"]/c-wiz[2]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div/button")));
        js.executeScript("arguments[0].click()",
                webDriver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div/button")));
        js.executeScript("arguments[0].click()", webDriver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[22]/div[2]/div[1]/a[1]")));

        Thread.sleep(8000);
        webDriver.close();
        webDriver.switchTo().window(handle1);

    }

}
