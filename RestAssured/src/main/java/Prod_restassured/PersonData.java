package Prod_restassured;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonData {
    private String id;
    private String name; // Add field for the full name
    private String dateOfBirth;
    private String gender;
    private String email;
    private List<Phone> phones;
    private String preferredName;
    private String restOfName;
    private List<String> roles;
    private String surname;
    private String campusStatus;
    private String cas;
        
    // Getters and setters (or lombok annotations)
    public List<String> getRoles() 
    {
		return roles;
	}
    
    public String getId() 
    {
        return id;
    }
    
    
    
public class Phone 
	{
    private String type;
    private String number;

    // Constructors, getters, and setters for type and number
    // ...
	}
}

