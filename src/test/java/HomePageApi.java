import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class HomePageApi {

    // Эндпоинт для главной страницы
    private final String endpoint = "/";

    public Response getHomePage() {
        return given()
                .log().ifValidationFails()
                .when()
                .get(endpoint);
    }
}