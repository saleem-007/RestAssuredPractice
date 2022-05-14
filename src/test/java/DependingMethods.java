import static io.restassured.RestAssured.given;

public class DependingMethods extends UtilClass {
    public static void main(String[] args)
    {

    }
    public Object getUserAuthToken()
    {
        return given().header("Content-Type", "application/json").header("Authorization", authToken).baseUri(CERBERUS_BASE_URI)
                .when().queryParam("identityType", "phoneNumber").queryParam("identityValue", "%2B91" + PHONE_NUMBER)
                .get("/auth_profiles").then().extract().asString();

    }
}
