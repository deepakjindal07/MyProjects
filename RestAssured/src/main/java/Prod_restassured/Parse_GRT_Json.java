package Prod_restassured;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Parse_GRT_Json extends PersonData {
	
	public static void main(String[] args) 
			throws JsonMappingException, JsonProcessingException {
        
		String GradRules = readGrtJsonFile();
        
        //GRT GRTX = new GRT();
        //String jsondata = GRTX.GraduationRules(readCookie);
        //System.out.println(GradRules);
        
        //Using fasterxml to parse the json. 
        ObjectMapper objectMapper = new ObjectMapper();
        //GRTData GRTData = objectMapper.readValue(GradRules, GRTData.class);

        //System.out.println("CatalogCode: " + GRTData.catalogCode());
        //System.out.println("MajorCode: " + GRTData.majorCode()); 

       // List<GRTData> GRTDatax = objectMapper.readValue
       // 		(GradRules, new TypeReference<List<GRTData>>() {});

        try {
            List<GRTData> grtDataList = objectMapper.readValue(GradRules, new TypeReference<List<GRTData>>() {});
            
            for (GRTData gRTData : grtDataList) {
                System.out.println("Catalog Code: " + gRTData.getCatalogCode());
                System.out.println("Major Code: " + gRTData.getMajorCode());
                System.out.println("Message: " + gRTData.getMessage());
                //System.out.println("Rules:");
//                List<Rule> rules = gRTData.getRules();
//                for (Rule rule : rules) {
//                    System.out.println("Minors: " + rule.getMinors());
//                    System.out.println("Emphases: " + rule.getEmphases());
//                    System.out.println("Concentrations: " + rule.getConcentrations());
//                    System.out.println("Clusters: " + rule.getClusters());
//                    System.out.println("Certificates: " + rule.getCertificates());
//                    System.out.println("Details:");
//                    List<CertificateDetail> details = rule.getDetails();
//                    for (CertificateDetail detail : details) {
//                        System.out.println("Type: " + detail.getType());
//                        System.out.println("CodeIn: " + detail.getCodeIn());
//                    }
//                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
	
	//close main
			
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
    
    public static String readGrtJsonFile() 
    {
    	String fileName = "GRT.json";
    	StringBuilder GradRules = new StringBuilder();
    	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
    		String line;
    		while ((line = bufferedReader.readLine()) != null) {
    			GradRules.append(line);
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return GradRules.toString();
    }
}
