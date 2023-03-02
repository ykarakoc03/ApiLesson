package postRequest;

import baseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;

public class Post01 extends GorestBaseURL {

    /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et


Bearer Token = 74506a56089f8b79af241d5924e501c60177c4f4eaa3024813670e8389badad7
   */


    @Test
    public void testPost1() {

        specification.pathParam("usersPath","users");
        //.header("Authorization", "Bearer 9aa94f55e266dfe9ab917a21554bb02c34e5cc9332a134e6bf492a47f9aefbde");
        //bu şekilde buradanda token yazabiliriz



        //Set Expected Data
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        System.out.println("Expected data: "+goRestApiTestData.statusCodeForPostInvalid());


        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer 74506a56089f8b79af241d5924e501c60177c4f4eaa3024813670e8389badad7").
                post("/{usersPath}");

        response.prettyPrint();



        //Assertion
        //  assertEquals(goRestApiTestData.statusCodeForPostInvalid(),response.getStatusCode());
        response.then().assertThat().statusCode(422);


    }



}
