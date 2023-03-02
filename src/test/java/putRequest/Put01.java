package putRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseURL {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
     */

    @Test
    public void testPut1() {

        //Step 1:
    specification.pathParams("todosPath","todos","idPath","198");

    //Step 2:
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        Map<String,String> expectedAndReqBodyMap = jsonPlaceHolderTestData.setUpDataTodos();

        System.out.println("expectedAndReqBodyMap = " + expectedAndReqBodyMap);

        Response response= given().
                spec(specification).
                contentType(ContentType.JSON).
                body(expectedAndReqBodyMap).
                when().
                put("/{todosPath}/{idPath}");

        response.prettyPrint();

        //Step 4:

        Map<String,Object> actualDataAndResponseBody = response.as(Map.class);
        System.out.println("actualDataAndResponseBody: " + actualDataAndResponseBody);

        assertEquals(expectedAndReqBodyMap.get("userId"),actualDataAndResponseBody.get("userId"));
        assertEquals(expectedAndReqBodyMap.get("title"),actualDataAndResponseBody.get("title"));
        assertEquals(expectedAndReqBodyMap.get("completed"),actualDataAndResponseBody.get("completed"));

        /*
        alternatif=

        for (String key : actualDataAndResponseBody.keySet()){
        Assert.assertEquals(expectedAndReqBodyMap..get(key) , actualDataAndResponseBody.get(key));}
         */

    }
}
