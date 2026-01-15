import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

class HealthTest {

    private static RequestSpecification requestSpec;

    @BeforeAll
    static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://preprod.shop.budu.ru")
                .build();
    }

    @Test
    void healthEndpointShouldReturnOk() {
        given()
                .spec(requestSpec)
                .when()
                .get("/health")
                .then()
                .statusCode(200)
                .body(is("ok"));
    }
}