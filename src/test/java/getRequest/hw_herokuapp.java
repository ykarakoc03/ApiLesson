package getRequest;

import baseURLs.HerokuBaseURL;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class hw_herokuapp extends HerokuBaseURL {

/*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/


    @Test
    public void Test_heroku() {

        specification.pathParam("booking","booking").queryParam("firstname","Sarah");

        Response response = given().spec(specification).when().get("/{booking}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        JsonPath jsonPath = response.jsonPath();

        List<String> data = (jsonPath.getList(""));

        System.out.println("data = " + data);

        assertFalse("bookingid bulundu", data.contains("bookingid"));









    }
}
