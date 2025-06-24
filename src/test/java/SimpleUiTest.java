import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleUiTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Установка пути к драйверу Chrome (скачайте драйвер, соответствующий вашей версии Chrome)
        System.setProperty("webdriver.chrome.driver", "путь/к/chromedriver");

        // Дополнительные настройки драйвера (например, режим без отображения окна)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Запускать в фоновом режиме
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Неявное ожидание
    }

    @Test
    public void testGoogleSearch() {
        // Открыть страницу
        driver.get("https://www.google.com");

        // Найти элемент поиска
        WebElement searchBox = driver.findElement(By.name("q"));
        // Ввести текст
        searchBox.sendKeys("Selenium testing");
        // Отправить запрос
        searchBox.submit();

        // Проверить заголовок страницы
        assertEquals("Selenium testing - Поиск в Google", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        // Закрыть браузер
        if (driver != null) {
            driver.quit();
        }
    }
}