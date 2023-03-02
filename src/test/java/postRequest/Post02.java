package postRequest;

import baseURLs.GorestBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojoDatas.GoRestCoApiPojo;
import testData.GoRestApiTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Post02 extends GorestBaseURL {


 /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */

    @Test
    public void testPost02() {

        //Set Base URL
        //https://gorest.co.in/public/v2/users
        specification.pathParam("usersPath", "users");

        //Step 2: Set Expected and Request Body
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        HashMap<String, String> reqBodyAndExpectedDataMap = goRestApiTestData.reqBodyAndExpectedData("Yakup K", "male", "yakppkk@gmail.comm", "active");
        System.out.println("reqBodyAndExpectedDataMap = " + reqBodyAndExpectedDataMap);

        //Step 3: Send a request
        Response response = given().
                spec(specification).contentType(ContentType.JSON).
                body(reqBodyAndExpectedDataMap).
                when().
                header("Authorization", "Bearer 74506a56089f8b79af241d5924e501c60177c4f4eaa3024813670e8389badad7").
                post("/{usersPath}");

        System.out.println("Response Body :");
        response.prettyPrint();


        //Step 4: Assertion
        //Alternatif -->
        //HashMap<String, Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);


        //Pojo kullanrak assert ediniz.

        GoRestCoApiPojo actualDataPojo = response.as(GoRestCoApiPojo.class);

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(actualDataPojo.getId(), reqBodyAndExpectedDataMap.get("id"));
        softAssert.assertEquals(actualDataPojo.getName(), reqBodyAndExpectedDataMap.get("name"));
        softAssert.assertEquals(actualDataPojo.getGender(), reqBodyAndExpectedDataMap.get("gender"));
        softAssert.assertEquals(actualDataPojo.getEmail(), reqBodyAndExpectedDataMap.get("email"));
        softAssert.assertEquals(actualDataPojo.getStatus(), reqBodyAndExpectedDataMap.get("status"));
    }
}
