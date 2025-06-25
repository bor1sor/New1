import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SimpleUiTest {

    public static void main(String[] args) throws IOException {
        // Установка пути к драйверу Chrome (замените на свой)
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");

        // Создание экземпляра ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Настройка неявного ожидания (опционально, но рекомендуется)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://rostov.rt.ru/");

        // Создание скриншота
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Сохранение скриншота
        FileUtils.copyFile(screenshotFile, new File("rostov_screenshot.png"));

        // Закрытие браузера
        driver.quit();

        System.out.println("Тест успешно завершен. Скриншот сохранен как rostov_screenshot.png");
    }
}