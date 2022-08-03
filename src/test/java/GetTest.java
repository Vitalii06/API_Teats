import settings.Settings;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends Settings {

    @Test
    void findByStatusGetTest() {
        given()
            .queryParams("status", "available")
        .when()
            .get("https://petstore.swagger.io/v2/pet/findByStatus")
        .then()
            .statusCode(200)
            .log().all();
    }
}