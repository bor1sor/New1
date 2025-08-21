import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class buduApiTest {

    @Test
    public void testBuduStatus() {
        RestAssured.baseURI = "https://budu.ru";
        long startTime = System.currentTimeMillis();
        given()
                .when().get("/api/v1/public/user/info") // Выполняем GET-запрос
                .then()
                .assertThat()
                .statusCode(200);
        long endTime = System.currentTimeMillis(); // фиксируем конец времени выполнения запроса
        long executionTime = endTime - startTime; // вычисляем общее время выполнения

        System.out.println("Время выполнения запроса /api/v1/public/user/info: " + executionTime + " мс");// Проверяем статус HTTP-код 200 OK (ставим код 500)
    }
}