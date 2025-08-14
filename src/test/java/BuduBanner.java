import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.time.Duration;

// Добавляем аннотацию для управления жизненным циклом экземпляров
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class BuduBanner {

    private final Logger logger = LogManager.getLogger(BuduBanner.class);
    WebDriver driver;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterAll
    public void endDriver() {
        if (driver != null) {
            driver.quit(); // Используем quit(), а не close()
        }
    }

    @Test
    @Order(1)
    public void openBuduRuAndLogin() throws InterruptedException {
        driver.get("https://budu.ru");

        WebElement catalogue = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[1]/div"));
        Thread.sleep(7500);
        catalogue.click();
        String expectedTitle  = "Диагностика";
        Label titleElement = null;
        String actualTitle = titleElement.getText(); // Доступно
        Assertions.assertEquals(expectedTitle, actualTitle, "Подраздел 'Диагностика' не отображается..");
        Thread.sleep(1500);
        driver.quit();

    }

}