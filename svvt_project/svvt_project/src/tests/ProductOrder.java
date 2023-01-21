package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ProductOrder {
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
    public void testOrdering() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("amila.causevic@stu.ibu.edu.ba");
        webDriver.findElement(By.xpath("//*[@id=\"target\"]/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("testiramoprojekatza10");
        webDriver.findElement(By.cssSelector("#target > button")).click();
        WebElement kfc = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[2]/div[1]/div/div[27]/div/div/a")));

        kfc.click();
        WebElement headline = webDriver.findElement(By.xpath("//*[@id=\"kategorije_lista\"]/h4[2]"));
        js.executeScript("arguments[0].scrollIntoView(true)", headline);
        webDriver.findElement(By.xpath("//*[@id=\"kategorije_lista\"]/div[2]/div[1]/div/div[1]/a")).click();
        Thread.sleep(3000);
        WebElement kfc_headline = webDriver.findElement(By.xpath("//*[@id=\"burger-twister-srednji-meni\"]/h4"));

        js.executeScript("arguments[0].scrollIntoView(true)", kfc_headline);
        webDriver.findElement(By.xpath("//*[@id=\"food_add_256810\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"addon_17309_256810_0\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"addon_17464_256810_0\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"addCustomizedProduct\"]")).click();
        WebElement checkout = webDriver.findElement(By.xpath("//*[@id=\"nakasu\"]"));
        js.executeScript("arguments[0].click()", checkout);
        webDriver.findElement(By.xpath("//*[@id=\"dugme_1\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"pay_now\"]")).click();

    }

}
