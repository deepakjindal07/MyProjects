package Prod_restassured;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Login_Get_Parse_Hold extends PersonData {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
        String readCookie = readSessionCookieFromFile();
        
        //GRT GRTX = new GRT();
        //String jsondata = GRTX.GraduationRules(readCookie);
        
        String jsondata = PersonHold(readCookie);
        
        System.out.println(jsondata);
        
//        //Using fasterxml to parse the json. 
//        ObjectMapper objectMapper = new ObjectMapper();
//        PersonData personData = objectMapper.readValue(jsondata, PersonData.class);
//
//        System.out.println("Inumber: " + personData.getId());
//        System.out.println("Roles: " + personData.getRoles()); 
//        System.out.println("Cas: " + PersonData.getClass());

	}

    public static String readSessionCookieFromFile() {
    	String fileName = "Prod_Cookie.txt";
    	StringBuilder cookieBuilder = new StringBuilder();
    	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
    		String line;
    		while ((line = bufferedReader.readLine()) != null) {
    			cookieBuilder.append(line);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return cookieBuilder.toString();
    }	
   	
		public static String PersonHold(String readCookie) {
        // Define the base URL for the API
        RestAssured.baseURI = "https://web.byui.edu/api/AcademicTools/v1";

        // Define the API endpoint
        String endpoint = "/persons/981074123/Holds";
        
        //String param = "majorcode=376&catalogcode=UG20";

        // Define the custom API key
        String apiKey = "ZE8Cy98vtxRaBFxgBLW8";

        // Define the content type
        String contentType = "application/x-www-form-urlencoded";

        // Make an HTTP GET request to the endpoint with authentication and content type
        Response response = RestAssured.given()
                .header("X-Byui-Api-Key", apiKey)
                .header("Content-Type", contentType)
                //.param("MajorCode", "376")
                .cookie(readCookie)
                .when()
                .get(endpoint);
     
        // Get and print the response status code and body
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        
        
        // Save it to GRT.json file under project folder. 
        String fileName = "Hold.json";
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

