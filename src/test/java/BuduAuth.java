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
public class BuduAuth {

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

        WebElement button = driver.findElement(By.cssSelector(
                "#header > div > div.header-desktop__search > div > div.header-desktop__actions > div.s-profile-navigation.header-desktop__actions-item > span"
        ));
        String backgroundColor = button.getCssValue("background-color");
        logger.info("Background color of the element: {}", backgroundColor);
    }

    @Test
    @Order(2)
    public void fillPersonalData() {
        // Реализовать заполнение личных данных здесь
    }
}