package Prod_restassured;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Login_GRT extends PersonData {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
        String readCookie = readSessionCookieFromFile();
        
        GRT GRTX = new GRT();
        String jsondata = GRTX.GraduationRules(readCookie);
        
        System.out.println(jsondata);
        
//        //Using fasterxml to parse the json. 
//        ObjectMapper objectMapper = new ObjectMapper();
//        PersonData personData = objectMapper.readValue(jsondata, PersonData.class);
//
//        System.out.println("Inumber: " + personData.getId());
//        System.out.println("Roles: " + personData.getRoles()); 
//        
        //System.out.println("Cas: " + PersonData.getClass());

	}

    public static String readSessionCookieFromFile() {
    	String fileName = "Cookie.txt";
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
}
