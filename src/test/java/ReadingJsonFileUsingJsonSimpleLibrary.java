import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingJsonFileUsingJsonSimpleLibrary {
    static String jsonPath="/Users/amit/IdeaProjects/JSONTutorialMaven/JsonFile/employee.json";

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader fileReader= new FileReader(jsonPath);
        Object obj=jsonParser.parse(fileReader);//this convert Json File to java obj
        JSONObject  empJsonObject= (JSONObject) obj;//Java object -> JSON object

        String fName= (String) empJsonObject.get("firstName");
        String lName= (String) empJsonObject.get("lastName");
        System.out.println("First Name: "+fName);
        System.out.println("Last Name: "+lName);

        JSONArray addressArray= (JSONArray) empJsonObject.get("address");

        for(int i=0;i<addressArray.size();i++){
            JSONObject address= (JSONObject) addressArray.get(i);
            String street= (String) address.get("street");
            String city= (String) address.get("city");
            String state= (String) address.get("state");

            System.out.println(street+"\t"+city+"\t"+state);
        }




    }
}
