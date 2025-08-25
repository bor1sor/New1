import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BuduPerformanceTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://budu.ru"; // устанавливаем базовую URI
    }

    /**
     * Метод для измерения времени выполнения нескольких запросов.
     */
    private long measureExecutionTime(String endpoint) {
        long startTime = System.currentTimeMillis();
        given()
                .when().get(endpoint)
                .then()
                .assertThat()
                .statusCode(200); // проверка статуса HTTP-кода
        return System.currentTimeMillis() - startTime;
    }

    @Test
    public void testMultipleEndpointsPerformance() {
        final String[] endpoints = {
                "/api/v1/public/user/faq",
                "/api/v1/public/user/info",
                "/api/v3/public/site/catalog/search/structure",
                "/api/v3/public/site/widget/home"};

        for (String endpoint : endpoints) {
            long executionTime = measureExecutionTime(endpoint);
            System.out.printf("Время выполнения %s: %d мс%n", endpoint, executionTime);
        }
    }
}