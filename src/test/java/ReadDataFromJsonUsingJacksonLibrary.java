import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadDataFromJsonUsingJacksonLibrary {
    static String jsonPath="/Users/amit/IdeaProjects/JSONTutorialMaven/JsonFile/employee.json";
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper= new ObjectMapper();
        File file = new File(jsonPath);
        //read json from file and map to person class
        Person person=objectMapper.readValue(file,Person.class);
        //Access data
        System.out.println("First Name: "+person.getFirstName());
        System.out.println("Last Name: "+person.getLastName());
        System.out.println("Address...");
        for(Address address:person.getAddress()){
            System.out.println("Street: " +address.getStreet());
            System.out.println("City: " +address.getCity());
            System.out.println("State: " +address.getState());
        }


    }
}
