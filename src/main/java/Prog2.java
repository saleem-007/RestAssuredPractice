import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Prog2 extends Prog1{
    @Test
    public void getReq() throws ParseException, IOException {
        JSONObject jb=new JSONObject();
        jb.put("amount", 31) ;
        jb.put("name", "Lidia Barron");
        jb.put("location", "Indore");
        jb.put("company","VANTAGE");
        jb.put("email", "lidiabarron@vantage.com");
        System.out.println(jb);
        if (jb.containsValue("Indore")) {jb.put("address", "New Ashok Nagar");}
        else {System.out.println("404 not found");}
        System.out.println(jb);

        System.out.println(getRequest());
        JSONObject jdb=getRequest();
        if (getRequest().containsValue("Indore"))
        {
            jdb.put( "address", "New Ashok Nagar");
        }else
        {
            System.out.println("value is incorrect");
        }
        System.out.println(jdb);
    }

    @Test
    public void nTest() throws ParseException, IOException {
        JSONParser js=new JSONParser();
        FileReader reader=new FileReader("src/test/resources/CreateUserDetails.json");
        JSONObject obj=(JSONObject) js.parse(reader);
        System.out.println(obj);
        // obj.remove("name");
        //System.out.println(obj);
       // obj.put("name", "morpheus");
       // System.out.println(obj);
        String response= given().baseUri("https://reqres.in/").basePath("/api/users")
                .body(obj).when().post().then().log().all().statusCode(201).extract().asString();
        System.out.println(response);
        Assert.assertTrue(response.contains("490"));




    }

}
