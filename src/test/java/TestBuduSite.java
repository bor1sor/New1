package com.example.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBuduSite {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Укажите путь к вашему chrome драйверу
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        if(driver != null){
            driver.quit(); // Закрываем браузер после завершения тестов
        }
    }

    @Test
    public void testOpenBuduRu() throws Exception{
        driver.get("https://budu.ru");  // Открываем страницу

        String title = driver.getTitle();   // Получаем заголовок страницы
        assert(title.contains("Буду"));     // Проверяем, что заголовок содержит слово 'Буду'
    }
}