import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class healthTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru";
    }

    @Test
    public void healthEndpointShouldReturnSimpleTextResponse() {
        given()
                .log().all()               // Полная трассировка запросов и ответов
                .when()
                .get("/health")           // Проверяем эндпоинт /health
                .then()
                .statusCode(200)              // Статус-код должен быть 200
                .body(is("ok"));              // Тело должно содержать ровно "ok"
    }
}
