import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Prog1 {

    public static JSONObject getRequest() throws ParseException, IOException {
        JSONParser jsonParser=new JSONParser();
        FileReader reader=new FileReader("src/test/resources/request.json");
        return (JSONObject) jsonParser.parse(reader);
    }

}
