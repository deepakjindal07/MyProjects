package restassured;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class ApiAuthenticationExample {
    public static void main(String[] args) 
    {
		
	  // Define the base URL for the API 
	  RestAssured.baseURI = "https://rachel.byui.edu";
	  
	  // Define the API endpoint 
	  String endpoint = "/Api/Services/Login";
	  
	  // Define the custom API key 
	  String apiKey = "LHGGiZaS8QgLV67qp5R3";
	  
	  // Define the content type 
	  String contentType = "application/x-www-form-urlencoded";
	  
	  // Define the request body parameters (if any) 
	  String requestBody = "username=EPSQA&password=tPX29S9TQhT7mxS2RDCjLPDIA0D65v4p";
	  
	  // Make an HTTP POST request to the endpoint with authentication and content	  type 
	  Response response = RestAssured.given() .header("X-Byui-Api-Key",
	  apiKey) .header("Content-Type", contentType) .body(requestBody) .when()
	  .post(endpoint);
	  
	  // Get and print the response status code and body int statusCode =
	  response.getStatusCode(); 
	  String responseBody = response.getBody().asString();
	  
	  // Extract the cookie from the authentication response from BYU 
	  String  cookieName ="BYUIForms"; // Replace with the actual cookie name 
	  Cookie sessionCookie = response.getDetailedCookie(cookieName);
	  //System.out.println("Cookie: "+sessionCookie);

	  //System.out.println("Response Status Code: " +statusCode);
	  System.out.println("Login ATI response: " + responseBody);
	  
	  //Save BYUi login Cookie to be used into other APIs for testing 
	  String fileName = "Cookie.txt"; try (FileWriter fileWriter = new FileWriter(fileName)) {
	  fileWriter.write(sessionCookie.toString());
	  System.out.println("Rachael Login Cookie Saved to: " + fileName); } catch
	  (IOException e) { e.printStackTrace(); } 
	  
        
      //String readCookie = readSessionCookieFromFile();
      //PersonRole PersonX = new PersonRole();
      //PersonX.personrole(readCookie);

    }//Close Main
    
    //Function to read the sessionCookie from the .txt file
	/*
	 * public static String readSessionCookieFromFile() { String fileName =
	 * "Cookie.txt"; StringBuilder cookieBuilder = new StringBuilder(); try
	 * (BufferedReader bufferedReader = new BufferedReader(new
	 * FileReader(fileName))) { String line; while ((line =
	 * bufferedReader.readLine()) != null) { cookieBuilder.append(line); } } catch
	 * (IOException e) { e.printStackTrace(); } return cookieBuilder.toString();
	 * 
	 * }//Close readSessionCookieFromFile
	 */    
}

