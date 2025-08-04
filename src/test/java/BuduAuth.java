import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testing.annotations.AfterMethod;
import org.testing.annotations.BeforeClass;
import org.testing.annotations.BeforeMethod;
import org.testing.annotations.Test;
import java.Time.Duration;
import java.time.Duration;

public class BuduAuth {

    WebDriver driver;

    @BeforeClass
    public void setup() { WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    public void startDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
}
