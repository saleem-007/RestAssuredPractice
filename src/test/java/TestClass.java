import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class TestClass extends Base {

    @Test
    public void verifyUserDetails() throws IOException, ParseException {
        JSONObject jb1 = addPath(CreateUserPayLoad);
        System.out.println(jb1);
        jb1.put("name", "Saleem M");
        Response response = given().log().all().header("Content-Type", "application/json").baseUri(BASEURI)
                .body(addPath(CreateUserPayLoad)).when().post(RESOURCE).then().log().all().extract().response();
        String name = response.jsonPath().get("name");
        System.out.println(name);
    }

    @Test
    public void VerifyData() throws IOException, ParseException {
        given().log().all().header("Content-Type", "application/json").baseUri(BASEURI)
                .body(addPath(CreateUserPayLoad)).when().post(RESOURCE)
                .then().log().all().assertThat();
    }
    @Test
    public void customerStatusChange()
    {
        given();
    }
}
