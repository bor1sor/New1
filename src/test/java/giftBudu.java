import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class giftBudu {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://preprod.shop.budu.ru/gift"; // базовый url
    }

    @Test
    public void testSiteAccessibility() {
        int statusCode = get("/").statusCode(); // Получаем статус-код главного пути '/'

        if (statusCode == 200) {
            System.out.println("Сайт доступен, статус-код: " + statusCode);
        } else {
            System.out.println("Сайт недоступен, статус-код: " + statusCode);
        }
    }
}