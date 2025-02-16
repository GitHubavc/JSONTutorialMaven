import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJson {
    public static void main(String[] args) throws IOException, ParseException {
        String JsonPath= "/Users/amit/IdeaProjects/JSONTutorialMaven/JsonFile/employee.json";
        JSONParser jsonParser= new JSONParser();
        FileReader reader= new FileReader(JsonPath);
        Object obj=jsonParser.parse(reader);
        JSONObject empJsonObj=(JSONObject)obj;

        String fName=(String)empJsonObj.get("firstName");
        String lName=(String)empJsonObj.get("lastName");

        System.out.println("FirstName "+fName);
        System.out.println("LastName "+lName);

        JSONArray array= (JSONArray) empJsonObj.get("address");

        for(int i=0;i<array.size();i++){
            JSONObject address= (JSONObject) array.get(i);

            String street= (String) address.get("street");
            String city= (String) address.get("city");
            String state= (String) address.get("state");

            System.out.println("Address of " +i+ " is ...");
            System.out.println("Street "+street);
            System.out.println("City " +city);
            System.out.println("State " +state);

        }

    }
}
