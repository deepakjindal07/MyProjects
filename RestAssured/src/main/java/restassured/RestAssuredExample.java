package restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredExample {

    @Test
    public void testGetRequest() {
        // Set the base URL for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Make an HTTP GET request to the endpoint "/users/1"
        given()
            .when()
            .get("/users/1")
            .then()
            .statusCode(200) // Validate the status code
            .contentType("application/json; charset=utf-8") // Validate the content type
            .body("id", equalTo(1)) // Validate the response body
            .body("name", equalTo("Leanne Graham"));
    }
}