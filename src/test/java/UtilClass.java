import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UtilClass {
    public static String CONTENT_TYPE="Content-Type";
    public static String CONTENT_VALUE="application/json";
    public static String AUTH_KEY_X_ZETA="X-Zeta-AuthToken";
    public static String AUTH_VALUE_X_ZETA="dS9PSFhaNHFvazZYTk4vM3hOQXkyRjZzWUxBVWYybysvZzk3M1REZVhvTlZRM1g2OkFRRlJrSW9iS255U3k4WGJpQkttNUVidjM2aEJNcTlvNkFrRG84WVRoTlpIZHVFNFRIMXVoaDFDMmw3QlRBWHhTbVpGRisyQ0c4WnUyNEFTcDdsYTJkR1FrQTB0RkdmWThybVVhSU1wUmE1SzcvMk5wU1BtRm1PYW9pc2ZhUjNzOXFEeE5kWXNxQ3RhaXNMSjRjNDNIUT09";

    public static String PHONE_NUMBER = "8721850530";
    public static String BETA_BASEURI = "https://sb1-god-plutus.hdfc-beta.zetaapps.in";
    public static String CERBERUS_BASE_URI = "https://api.hdfc-beta.zetaapps.in/cerberus2/domains/13-payzapp-users.in";


    public static String authToken = "Bearer dS9PSFhaNHFvazZYTk4vM3hOQXkyRjZzWUxBVWYybysvZzk3M1REZVhvTlZRM1g2OkFRRlJrSW9iS255U3k4WGJpQkttNUVidjM2aEJNcTlvNkFrRG84WVRoTlpIZHVFNFRIMXVoaDFDMmw3QlRBWHhTbVpGRisyQ0c4WnUyNEFTcDdsYTJkR1FrQTB0RkdmWThybVVhSU1wUmE1SzcvMk5wU1BtRm1PYW9pc2ZhUjNzOXFEeE5kWXNxQ3RhaXNMSjRjNDNIUT09";

    public static String GENERATE_AUTH_TOKEN_RESOURCE = "/auth_profiles?identityType=phoneNumber&identityValue=%2B91";
    public static String ONBOARD_CUSTOMER_RESOURCE = "/plutus-integration-migration/obplcm/onboardCustomer";
    public static String ONBOARD_RESOURCE="/plutus-onboarding/ifi/13/";
    public static String GET_ACCOUNT_HOLDER_ID_END_POINT="get/user/";

    public static String ACCOUNT_HOLDER_ID;
    public static String OC_FP = "src/test/resources/OnboardCustomer.json";
    public static String TRANSACTION_PATH = "";


    public static JSONObject geJsonObject(String path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        return (JSONObject) obj;
    }

    public static void on() {
      Response response=given().urlEncodingEnabled(false).log().all().header("Content-Type", "application/json").header("Authorization", authToken).baseUri(CERBERUS_BASE_URI)
                .queryParam("identityType", "phoneNumber").queryParam("identityValue", "%2B91"+PHONE_NUMBER)
                .when()
                .get("/auth_profiles").then().log().all().extract().response();

      List<String> e = response.getBody().jsonPath().getList("authProfiles.credentials[0].identityValue");
      List<String> b = response.getBody().jsonPath().getList("authProfiles.credentials[0].identityId");
      String identityValue= String.valueOf(e).replace("[","").replace("]","");
      String identityId=String.valueOf(b).replace("[","").replace("]","");
      System.out.println(identityValue);
      System.out.println(identityId);
      System.out.println(response.statusCode());
      List<String> str=response.jsonPath().getList("authProfiles.authProfileId");
      String authProfileID=String.valueOf(str).replace("[","").replace("]","");
      System.out.println(authProfileID);
    }
    public static String getAccountHolderID()
    {
        String accountHolderID=given().log().all().urlEncodingEnabled(false).header(CONTENT_TYPE, CONTENT_VALUE).header(AUTH_KEY_X_ZETA, AUTH_VALUE_X_ZETA)
                .param("phoneNumber", "%2B91"+PHONE_NUMBER).baseUri(BETA_BASEURI).when()
                .get(ONBOARD_RESOURCE+GET_ACCOUNT_HOLDER_ID_END_POINT).then().log().all().statusCode(200).extract().path("accountHolderID");


        return accountHolderID;
    }
}
