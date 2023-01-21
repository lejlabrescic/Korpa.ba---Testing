package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

class CustomerSupport {
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
    void testCustomerSupport() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("amila.causevic@stu.ibu.edu.ba");
        webDriver.findElement(By.xpath("//*[@id=\"target\"]/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("testiramoprojekatza10");
        webDriver.findElement(By.cssSelector("#target > button")).click();
        webDriver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")).click();
        WebElement customerSupport = webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/h2"));
        String customerSupportText = customerSupport.getText();
        assertEquals("Popunite potrebne podatke", customerSupportText);
        WebElement name = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[1]/div/input"));
        name.sendKeys("Meho Mehic");
        WebElement email = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[2]/div/input"));
        email.sendKeys("meho.mehic@gmail.com");
        WebElement phoneNumber = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[3]/div/input"));
        phoneNumber.sendKeys("+38761348304");
        WebElement message = webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[4]/div/textarea"));
        message.sendKeys(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                        + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
                        + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
                        + "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        Thread.sleep(3000);
        Thread.sleep(3000);
        String title = webDriver.findElement(By.xpath("/html/body/section[1]/div[3]/div/div/div/div/h1")).getText();
        assertEquals("Podrška korisnicima", title);
        assertEquals("Popunite potrebne podatke", customerSupportText);
        WebElement inputDetails = webDriver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/h2"));
        String element = webDriver.findElement(RelativeLocator.with(By.tagName("div")).below(inputDetails)).getText();
        assertEquals("Hvala na javljanju! Ubrzo ćemo Vas kontaktirati.", element);
        // webDriver.findElement(By.xpath("//*[@id=\"section\"]/section/form/div[5]/button")).click();
    }

}
