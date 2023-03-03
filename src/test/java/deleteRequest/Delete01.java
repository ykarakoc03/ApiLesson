package deleteRequest;

import baseURLs.HerokuBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete01 extends HerokuBaseURL {


  /*
        Given
            1)https://restful-booker.herokuapp.com/booking/5
            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */

    @Test
    public void delete01() {
        //Set URL
        //https://restful-booker.herokuapp.com/booking/37
        specification.pathParams("bookingPath","booking",
                "idPath","19");


        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                when().
                delete("/{bookingPath}/{idPath}");


        response.prettyPrint();

        //Step 4:
        response.then().assertThat().statusCode(201);

        String responsBody = response.asString();
        assertEquals(responsBody,"Created");


    }
}
