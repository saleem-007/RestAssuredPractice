

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Base {
    public static String BASEURI="https://reqres.in/";
    public static String RESOURCE="/api/users";

    public static String DUNZO_BASE_URI="https://cdn-api.co-vin.in";


    public static String CreateUserPayLoad="src/test/resources/CreateUserDetails.json";
    public static String CreateUserSchemaValidation="src/test/resources/schemaValidation.json";
    public static JSONObject addPath(String path) throws IOException, ParseException {
        JSONParser jb=new JSONParser();
        FileReader fl=new FileReader(path);
        Object n=jb.parse(fl);
        return (JSONObject) n;
    }
}
