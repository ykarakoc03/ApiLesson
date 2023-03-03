package deleteRequest;

import baseURLs.DummyBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyBaseURL {

     /*
    Given
            1)https://dummy.restapiexample.com/api/v1/delete/379

        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 200 olduğunu
		 And
		    Response body in

		    {
    "status": "success",
    "data": "719",
    "message": "Successfully! Record has been deleted"
}

     */

    @Test
    public void delete02() {


        specification.pathParams("deletePath","delete","idPath","379");


        DummyRestApiTestData dummyRestApiTestData=new DummyRestApiTestData();
        HashMap<String, String> expectedDataMap = dummyRestApiTestData.setExpectedDataForDelete("success","379","Successfully! Record has been deleted");


        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/{deletePath}/{idPath}");

        response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedDataMap.get("status"),jsonPath.getString("status"));
        assertEquals(expectedDataMap.get("data"),jsonPath.getString("data"));
        assertEquals(expectedDataMap.get("message"),jsonPath.getString("message"));



    }
}
