import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;

public class ScrollTest {
    public static void main(String[] args) {
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

            long totalHeight = Long.parseLong(((JavascriptExecutor) driver).executeScript("return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);").toString());

            for(long i = 0; i <= totalHeight; i += 300) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + i + ");");
                try {
                    Thread.sleep(500); // пауза между шагами
                } catch(InterruptedException ignored) {}
            }

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