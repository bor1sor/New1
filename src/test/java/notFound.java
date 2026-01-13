import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class notFound {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru/info/1";
    }

    @Test
    public void testSiteAccessibility() {
        given()
                .log().all() // Логируем запрос для отладки
                .when()
                .get("/notfound")
                .then()
                .log().ifValidationFails() // Логируем ответ только при ошибке
                .statusCode(404) // Проверка статус-кода
                .time(lessThan(2000L)); // Проверка, что ответ пришел быстрее чем за 2 сек
    }
}