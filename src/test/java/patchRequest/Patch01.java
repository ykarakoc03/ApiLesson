package patchRequest;

import baseURLs.HerokuBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends HerokuBaseURL {

    /*
     Given
	        1) https://restful-booker.herokuapp.com/booking/32
	        2) {
    "firstname" : "Drake",
    "lastname" : "CW"
}
3) Auth olarak --> Header da Basic YWRtaW46cGFzc3dvcmQxMjM=


        When
	 		Kullanıcı PATCH Req atar
	    Then
	   	   Status code is 200
	   	   And response body de firs ve lastname değiştiğini assert ediniz.
	   	    {
    "firstname": "Drake",
    "lastname": "CW",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void patch01() {
        //Set URL
        //https://restful-booker.herokuapp.com/booking/37
        specification.pathParams("bookingPath","booking",
                "idPath","32");


        //Step 2:
        File file = new File("src/test/java/testData/FirstnameAndLastName.json");
        HashMap<String,Object> expectedDataAndReqBody = JsonToJava.convertJsonToJavaObject(file,HashMap.class);


        //Step 3:Send a request
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM").
                body(expectedDataAndReqBody).
                when().
                patch("/{bookingPath}/{idPath}");

        response.prettyPrint();
        Map<String,Object> actualData = response.as(Map.class);
        assertEquals(actualData.get("firstname"),expectedDataAndReqBody.get("firstname"));
        assertEquals(actualData.get("lastname"),expectedDataAndReqBody.get("lastname"));


        //Step 4: Assertion





    }
}
