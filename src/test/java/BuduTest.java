import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuduTest {

    private final static Logger logger = LogManager.getLogger(BuduTest.class);
    private WebDriver driver; // Переменная перемещается сюда, теперь доступна всем методам

    @BeforeAll
    public static void driverSetup() {
        logger.trace("Загрузка ВебДрайвера - начало");
        WebDriverManager.chromedriver().setup();
        logger.trace("Загрузка ВебДрайвера - конец");
    }

    @BeforeEach
    public void setUp() {
        logger.trace("Открытие браузера - начало");
        driver = new ChromeDriver(); // Инициализируем здесь объект driver
        logger.trace("Открытие браузера - конец");

        logger.trace("Открытие сайта - начало");
        driver.get("https://budu.ru");
        logger.trace("Открытие сайта - конец");
    }

    @AfterEach
    public void tearDown() {
        logger.trace("Закрытие браузера - начало");
        if (driver != null) {
            driver.quit(); // Закрываем браузер после каждого теста
        }
        logger.trace("Закрытие браузера - конец");
    }

    @Test
    public void firstTest() {
        String expectedTitle = "budu.ru";
        String actualTitle = driver.getTitle(); // Теперь доступно
        Assertions.assertEquals(expectedTitle, actualTitle, "Проверка заголовка страницы.");
    }

    @Test
    public void secondTest() {
        String expectedTitle = "Каталог";
        String actualTitle = driver.getTitle(); // Доступно
        Assertions.assertEquals(expectedTitle, actualTitle, "Проверка альтернативного заголовка страницы.");
    }
}