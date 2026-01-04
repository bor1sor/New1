import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class buduTimingInfo {

    @Test
    public void testBuduStatus() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru";
        long startTime = System.currentTimeMillis();
        given()
                .when().get("/proxy/v3/public/order/appointment/list") // Выполняем GET-запрос
                .then()
                .assertThat();
        long endTime = System.currentTimeMillis(); // фиксируем конец времени выполнения запроса
        long executionTime = endTime - startTime; // вычисляем общее время выполнения

        System.out.println("Время выполнения запроса proxy/v3/public/order/appointment/list: " + executionTime + " мс");// Проверяем статус HTTP-код 200 OK (ставим код 500)
    }
}