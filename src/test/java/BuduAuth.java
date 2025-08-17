import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.time.Instant;

// Добавляем аннотацию для управления жизненным циклом экземпляров
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class BuduAuth {

    private final Logger logger = LogManager.getLogger(BuduAuth.class);
    WebDriver driver;
    private Alert inputPhone;
    private Instant wait;

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

        WebElement authButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[2]/div/div[2]/div[3]/span"));
        Thread.sleep(3000);
        authButton.click();
        Thread.sleep(3000);
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"floatingInput\"]"));
        Thread.sleep(3000);
        phoneInput.sendKeys("+9017664511");
        Thread.sleep(3000);
        WebElement getCode = driver.findElement(By.xpath("//*[@id=\"redesign-layout\"]/main/div/div/div/div/div/div[2]/button"));
        Thread.sleep(3000);
        getCode.click();
        Thread.sleep(3000);
        WebElement enterCode = driver.findElement(By.cssSelector("#floatingInput"));
        enterCode.sendKeys("0000");
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"redesign-layout\"]/main/div/div/div/div/div/div[1]/div[2]/div/p"));
        String expectedError = "Неверный код из смс";
        String actualErrorText = errorMessage.getText();
        Assertions.assertEquals(expectedError, actualErrorText, "Ошибка должна содержать текст \"Неверный код из смс\"");
        driver.quit();
    }
}