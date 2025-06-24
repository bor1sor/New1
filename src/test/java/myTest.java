import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;

public class myTest {
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
            driver.get("https://budu.ru");

            // Выполняем дальнейшие действия с драйвером
        } finally {
            // Завершаем сессию браузера
            driver.quit();
        }
    }
}