import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BuduTimingStructure {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru/"; // устанавливаем базовую URI
    }

    /**
     * Метод для измерения времени выполнения одного запроса.
     */
    private long measureExecutionTime(String endpoint) {
        long startTime = System.currentTimeMillis();
        given()
                .when().get(endpoint)
                .then()
                .assertThat();
        // проверка статуса HTTP-кода
        return System.currentTimeMillis() - startTime;
    }

    @Test
    public void testMultipleEndpointsPerformance() {
        final String[] endpoints = {"api/v1/public/seller/catalog/list",};

        for (String endpoint : endpoints) {
            long executionTime = measureExecutionTime(endpoint);
            System.out.printf("Время выполнения %s: %d мс%n", endpoint, executionTime);
        }
    }
}