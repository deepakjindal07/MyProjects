package restassured;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

class PersonRole{
		
		public String personrole(String readCookie) {
        // Define the base URL for the API
        RestAssured.baseURI = "https://web.byui.edu/api/academictools/v1";

        // Define the API endpoint
        String endpoint = "/Persons/843849732/";

        // Define the custom API key
        String apiKey = "ZE8Cy98vtxRaBFxgBLW8";

        // Define the content type
        String contentType = "application/x-www-form-urlencoded";

        // Make an HTTP GET request to the endpoint with authentication and content type
        Response response = RestAssured.given()
                .header("X-Byui-Api-Key", apiKey)
                .header("Content-Type", contentType)
                .cookie(readCookie)
                .when()
                .get(endpoint);
     
        // Get and print the response status code and body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        
        String fileName = "Person.json";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(responseBody);
            System.out.println("Response body has been saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Response Status Code: " + statusCode);
        //System.out.println("Response Body: " + responseBody);
		return responseBody;
    }
	
}

