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
public class BuduSlider {

    private final Logger logger = LogManager.getLogger(BuduSlider.class);
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

        WebElement sliderButton = driver.findElement(By.cssSelector("#\\32 3 > div > div.slider-base__button-next-image-carousel.slider-base__button--carousel-slider.slider-base__button.slider-base__button-next"));
        Thread.sleep(3500);
        sliderButton.click();
        driver.quit();

    }

}