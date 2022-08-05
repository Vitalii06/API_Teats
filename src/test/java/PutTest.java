import org.junit.jupiter.api.Test;
import settings.Settings;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutTest extends Settings {

    Long postTest() {
        HashMap<String, Object> bodyMap = new HashMap<>();
        HashMap<String, Object> category = new HashMap<>();
        category.put("id", 0);
        category.put("name", "string");

        bodyMap.put("id", 0);
        bodyMap.put("name", "doggie");
        bodyMap.put("category", category);

        return
            given()
                .body(bodyMap)
            .when()
                .post("https://petstore.swagger.io/v2/pet")
            .then()
                .statusCode(200)
                .log().all().extract().response().path("id");
    }

    @Test
    void petPutTest() {
        Long id = postTest();

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", id);
        bodyMap.put("name", "doggie2");

        given()
            .body(bodyMap)
        .when()
            .put("https://petstore.swagger.io/v2/pet")
        .then()
            .statusCode(200)
            .log().all();
    }
}
