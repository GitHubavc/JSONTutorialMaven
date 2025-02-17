package JsonPackage;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadingDataFromJsonUsingGsonLibrary {
    static String jsonPath="/Users/amit/IdeaProjects/JSONTutorialMaven/JsonFile/employee.json";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader= new FileReader(jsonPath);
        Gson gson=new Gson();
        Person person=gson.fromJson(reader,Person.class);
        //Access data
        System.out.println("First Name: "+person.getFirstName());
        System.out.println("Last Name: "+person.getLastName());
        System.out.println("JsonPackage.Address...");
        for(Address address:person.getAddress()){
            System.out.println("Street: " +address.getStreet());
            System.out.println("City: " +address.getCity());
            System.out.println("State: " +address.getState());
        }
    }
}
