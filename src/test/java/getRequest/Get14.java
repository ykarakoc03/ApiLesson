package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14 extends JsonPlaceHolderBaseURL {
/*


        Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

  {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }

     */

    @Test
    public void testGet14() {

        specification.pathParams("todosPath","todos","idPath","198");

        String expectedData =" {\n" +
                "  \"userId\": 10,\n" +
                "  \"id\": 198,\n" +
                "  \"title\": \"quis eius est sint explicabo\",\n" +
                "  \"completed\": true\n" +
                "}";



        HashMap<String, Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap = " + expectedDataMap);

        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");

        HashMap<String, Object> actualdDataMap= JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        //  alternatif atama ---------------> =response.as(HashMap.class)

        // JsonPath jsonPath = response.jsonPath();


        System.out.println("actualdDataMap = " + actualdDataMap);

        assertEquals(expectedDataMap.get("id"),actualdDataMap.get("id"));


    }
}
