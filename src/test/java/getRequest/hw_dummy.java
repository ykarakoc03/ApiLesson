package getRequest;

import baseURLs.DummyBaseURL;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyWithHwDummy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class hw_dummy extends DummyBaseURL {


    /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

*/


    @Test
    public void hw_Dummy() {

        specification.pathParams("employeePath", "employee", "idPath", "1");


        Response response = given().spec(specification).when().get("/{employeePath}/{idPath}");
        response.prettyPrint();

        DummyWithHwDummy ExpectedData = new DummyWithHwDummy(200, 1, "Tiger Nixon", 320800, 61, "", "Successfully! Record has been fetched.");


        JsonPath jsonPath = response.jsonPath();
        Map<String, Object> actualData = jsonPath.getMap("data");


        assertEquals(ExpectedData.dataMap().get("id"), actualData.get("id"));
        assertEquals(ExpectedData.dataMap().get("employee_name"), actualData.get("employee_name"));
        assertEquals(ExpectedData.dataMap().get("employee_salary"), actualData.get("employee_salary"));
        assertEquals(ExpectedData.dataMap().get("employee_age"), actualData.get("employee_age"));
        assertEquals(ExpectedData.dataMap().get("profile_image"), actualData.get("profile_image"));


    }
}
