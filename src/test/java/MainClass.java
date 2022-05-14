

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

public class MainClass extends UtilClass {
    DependingMethods token = new DependingMethods();

    @Test
    public void kill() throws IOException, ParseException {
        //given, when, then
        //given - all input details
        //when - Submit the api - http method and resource
        //Then - validate the response
        JSONObject jb = geJsonObject(UtilClass.OC_FP);
        jb.put("accountHolderId", "8e6301fe-ced9-4ca5-ad94-1a9211a4d403");
        String str=given().log().all().header("Content-Type", "application/json").header("Authorization", authToken)
                .baseUri(UtilClass.BETA_BASEURI)
                .body(jb).when().post(UtilClass.ONBOARD_CUSTOMER_RESOURCE)
                .then().log().all().extract().asString();





    }

    @Test
    public void nonStaticBill() {
        String hello = (String) token.getUserAuthToken();
        System.out.println(hello);

    }

    @Test
    public void staticStill()
    {
        Response accountHolderID=given().log().all().urlEncodingEnabled(false).header(CONTENT_TYPE, CONTENT_VALUE).header(AUTH_KEY_X_ZETA, AUTH_VALUE_X_ZETA)
                .param("phoneNumber", "%2B91"+PHONE_NUMBER).baseUri(BETA_BASEURI).when()
                .get(ONBOARD_RESOURCE+GET_ACCOUNT_HOLDER_ID_END_POINT).then().log().all().statusCode(200).extract().response();  //.extract().path("accountHolderID");

         String ahid=accountHolderID.jsonPath().get("accountHolderID");
        System.out.println(ahid);//6e0a3742-6dd6-4f39-862e-cc5f1ac79896
        String status=accountHolderID.jsonPath().get("vectors[0].status");
        System.out.println(status);//ENABLED
        String authId=accountHolderID.jsonPath().get("vectors[3].value");
        System.out.println(authId);//mSObtTepw35AnyNqgN8GXg==
        String kycStatus=accountHolderID.jsonPath().get("KYCStatus.kycStatus");
        System.out.println(kycStatus);//MINIMAL
        if(kycStatus!="FULL"||kycStatus!="SHORTFALL")
        {
            System.out.println("Verify the user limit = Limit of the user must be 10000");
        }
        else
        {
            System.out.println("ignore");
        }


    }
    @Test
    public void getAholderID()
    {
        String ahID=getAccountHolderID();
        System.out.println(ahID);

    }


}
