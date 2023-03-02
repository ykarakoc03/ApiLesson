package postRequest;

import baseURLs.DummyBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hw_PostDummy extends DummyBaseURL {


   /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */

    @Test
    public void hw_postTest() {

        specification.pathParam("createPath","create");

        String bodyData = "      {\n" +
                "  \"name\": \"Drake F.\",\n" +
                "  \"salary\": \"40000\",\n" +
                "  \"age\": \"27\"\n" +
                "}";


        HashMap<String,Object> bodyDataMap= JsonToJava.convertJsonToJavaObject(bodyData,HashMap.class);

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(bodyDataMap).
                when().
                post("/{createPath}");

        response.prettyPrint();




        HashMap<String,Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("status","success");
        expectedDataMap.put("data",bodyDataMap);
        expectedDataMap.put("message","Successfully! Record has been added.");

        System.out.println("expectedDataMap = " + expectedDataMap);


        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        //HashMap<String,Object> actualDataMap2=JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);

        assertEquals(actualDataMap.get("status"),expectedDataMap.get("status"));
        assertEquals(actualDataMap.get("message"),expectedDataMap.get("message"));
        assertEquals(((Map)expectedDataMap.get("data")).get("name"),((Map)actualDataMap.get("data")).get("name"));
        assertEquals(((Map)expectedDataMap.get("data")).get("salary"),((Map)actualDataMap.get("data")).get("salary"));
        assertEquals(((Map)expectedDataMap.get("data")).get("age"), ((Map)actualDataMap.get("data")).get("age"));






    }
}
