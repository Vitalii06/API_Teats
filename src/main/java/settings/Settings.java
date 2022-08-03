package settings;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class Settings {
    static {
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();
    };
}
