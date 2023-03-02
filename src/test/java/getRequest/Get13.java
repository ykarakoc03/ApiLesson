package getRequest;

import baseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13 extends GorestBaseURL {
    
       /*


        Given
            https://gorest.co.in/public/v2/users/725273
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

      {
        "id": 739373,
        "name": "Dhatri Tagore",
        "email": "tagore_dhatri@hansen-howe.info",
        "gender": "male",
        "status": "inactive"
    }




     */

    @Test
    public void get13(){


        //Step 1:  Set URL
        //https://gorest.co.in/public/v2/users/725273
        specification.pathParams("usersPath","users",
                "idPath","739373");


        //Step 2: Expected Data

        GoRestCoApiPojo goRestCoApiPojo = new GoRestCoApiPojo(739373,"Dhatri Tagore",
                "tagore_dhatri@hansen-howe.info","male","inactive");


        System.out.println("GoRestCoAPİ: " + goRestCoApiPojo);


        //Step 3: Send a Request
        Response response = given().
                spec(specification).
                when().get("/{usersPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();

        //Step 4:Assertion

        //POjO --> Expected Data , Request Body,  Actual data

        GoRestCoApiPojo actualDataPojo = response.as(GoRestCoApiPojo.class);
        System.out.println("actualDataPojo = " + actualDataPojo);

        assertEquals(goRestCoApiPojo.getEmail(),actualDataPojo.getEmail());
        assertEquals(goRestCoApiPojo.getGender(),actualDataPojo.getGender());
        assertEquals(goRestCoApiPojo.getName(),actualDataPojo.getName());
        assertEquals(goRestCoApiPojo.getId(),actualDataPojo.getId());
        assertEquals(goRestCoApiPojo.getStatus(),actualDataPojo.getStatus());


    }

}
