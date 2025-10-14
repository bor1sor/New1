import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class giftBudu {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://budu.ru/gift"; // Установили базовую URI
    }

    @Test
    public void testSiteAccessibility() {
        int statusCode = get("/").statusCode(); // Получаем статус-код главного пути '/'

        if (statusCode == 200) {
            System.out.println("Сайт доступен, статус-код: " + statusCode);
        } else {
            System.out.println("Ошибка доступа к сайту, статус-код: " + statusCode);
        }
    }
}