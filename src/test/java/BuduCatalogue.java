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

import java.time.Duration;

// Добавляем аннотацию для управления жизненным циклом экземпляров
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class BuduCatalogue {

    private final Logger logger = LogManager.getLogger(BuduAuth.class);
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
    public void openBuduRuAndLogin() {
        driver.get("https://budu.ru");

        WebElement catalogue = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[1]/div"));
        catalogue.click();
        WebElement diagnostics = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[1]/div/div/button[2]/span/span"));
        diagnostics.click();
        WebElement showAll = driver.findElement(By.xpath("//*[@id=\"mainLayout\"]/main/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/button/span/span"));
        showAll.click();
        driver.quit();

    }

    @Test
    @Order(2)
    public void fillPersonalData() {
        driver.quit(); // Реализовать заполнение личных данных здесь
    }

}