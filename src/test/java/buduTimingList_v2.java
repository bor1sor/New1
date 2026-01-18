import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class buduTimingList_v2 {

    private static RequestSpecification requestSpec;

    @BeforeAll
    static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://preprod.shop.budu.ru")
                // Логируем только если тест упал, чтобы не забивать консоль
                .build();
    }

    @Test
    public void appointmentListResponseTimeTest() {
        long responseTime = given()
                .spec(requestSpec)
                .when()
                .get("/proxy/v3/public/order/appointment/list")
                .then()
                .statusCode(200) // Проверяем успешность запроса
                .time(lessThan(2000L), TimeUnit.MILLISECONDS) // Тест упадет, если ответ дольше 2 секунд
                .extract()
                .timeIn(TimeUnit.MILLISECONDS);

        System.out.println("Фактическое время отклика: " + responseTime + " мс");
    }
}