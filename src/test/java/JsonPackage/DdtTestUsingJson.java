package JsonPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class DdtTestUsingJson {
    WebDriver driver;
    static String jsonPath="/Users/amit/IdeaProjects/JSONTutorialMaven/JsonFile/testData.json";

    @BeforeClass
    void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    void tearDown()
    {
        driver.close();
    }

    @Test(dataProvider = "dp")
    void login(String data)
    {
        String user[]=data.split(",");
        driver.get("https://demo.nopcommerce.com/login?returnurl=%2F");
        driver.findElement(By.id("Email")).sendKeys(user[0]);
        driver.findElement(By.id("Password")).sendKeys(user[1]);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        String act_title=driver.getTitle();
        String ext_title="nopCommerce demo store. Login";
        Assert.assertEquals(act_title,ext_title);


    }

    @DataProvider(name="dp")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader reader = new FileReader(jsonPath);
        Object obj=jsonParser.parse(reader);
        JSONObject userLoginJsonObj= (JSONObject) obj;
        JSONArray userLoginsArray= (JSONArray) userLoginJsonObj.get("userlogins");

        String arr[]=new String[userLoginsArray.size()];

        for(int i=0;i<userLoginsArray.size();i++){
            JSONObject users= (JSONObject) userLoginsArray.get(i);
            String user= (String) users.get("username");
            String pwd= (String) users.get("password");

            arr[i]=user+","+pwd;
        }
        return arr;
    }

}
