import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResponseApiTest_1 {

    private HomePageApi homePageApi;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru";
        // Инициализация API-object
        homePageApi = new HomePageApi();
    }

    @Test
    @DisplayName("Проверка доступности главной страницы через POM")
    public void testSiteAccessibility() {
        // Выполняем действие через объект страницы
        Response response = homePageApi.getHomePage();

        // Проводим валидацию результата
        response.then()
                .log().ifValidationFails()
                .statusCode(200);
    }
}