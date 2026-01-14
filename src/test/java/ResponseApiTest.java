import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ResponseApiTest { // Переименовано в соответствии с CamelCase

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru";
    }

    @Test
    @DisplayName("Проверка доступности главной страницы сайта")
    public void testSiteAccessibility() {
        given()
                .log().ifValidationFails() // Логируем запрос, если тест упадет
                .when()
                .get("/")
                .then()
                .log().ifValidationFails() // Логируем ответ, если тест упадет
                .statusCode(200); // Автоматическая проверка: если не 200, тест провален
    }
}