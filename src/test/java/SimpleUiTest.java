import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

public class SimpleUiTest {


    public void main() {
        // Создаем опции для Chrome
        ChromeOptions options = new ChromeOptions();

        // Создаем сервис с нужными параметрами журналов
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out)       // Отправляем логи в stdout
                .build();

        // Инициализируем драйвер
        WebDriver driver = new ChromeDriver(service, options);

        try {
            // Открываем страницу
            driver.get("https://rostov.rt.ru/");

            Thread.sleep(5000);

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshotFile, new File("page_screenshot.png"));
            } catch (IOException e) {
                System.err.println("Ошибка при создании скриншота: " + e.getMessage());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Завершаем сессию браузера
            driver.quit();
        }
    }
}