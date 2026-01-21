import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class PopularList {

    private static RequestSpecification requestSpec;

    @BeforeAll
    static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://yadnex.ru")
                // Можно сразу добавить общие настройки, если они нужны для всех тестов
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    @DisplayName("Проверка работоспособности сервиса")
    void healthEndpointShouldReturnOk() {
        given()
                .spec(requestSpec)
                .when()
                .get("/health")
                .then()
                .statusCode(200)
                .body(is("ok"));
    }

    @Test
    @DisplayName("Тест метода GET из Swagger")
    void swaggerGetMethodTest() {
        given()
                .spec(requestSpec) // Используем общую спецификацию без токена
                .when()
                // Выполняем GET-запрос
                .get("метод")
                .then()
                // Логируем полный ответ в консоль
                .log().all()
                // Проверяем, что сервер ответил 200 OK
                .statusCode(200)
                // Опционально: проверка поля "id"
                .body("id", notNullValue());
    }
}