import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BuduCatalogue_2 {

    private final static Logger logger = LogManager.getLogger(BuduCatalogue_2.class);
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        logger.info("Запуск Chrome");
        driver = new ChromeDriver();

        // Настройка ожиданий и размера окна
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        logger.info("Переходим на маркетплейс");
        driver.get("https://preprod.shop.budu.ru");
    }

    @Test
    @DisplayName("Проверка заголовка главной страницы")
    public void titleShouldBeCorrect() {
        String expectedTitle = "budu.ru"; // Уточни title страницы
        String actualTitle = driver.getTitle();

        logger.info("Фактический заголовок: " + actualTitle);
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок страницы не совпадает с ожидаемым");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Браузер закрыт");
        }
    }
}