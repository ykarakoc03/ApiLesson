package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseURL {

    /*
          Given
              https://jsonplaceholder.typicode.com/users
          When
               Kullanıcı GET Methodu ile Request Gönderir
          Then
              Status Code un "200" olduğunu Assert et
          And
              Content Type ın "application/json" olduğunu assert et
          And
              Data uzunluğunun 10 olduğunu assert ediniz.

       */
    @Test
    public void testGet04() {

        //Step 1: Set URL :"https://jsonplaceholder.typicode.com/users
        specification.pathParams("users","users");

        // Step 2: Expected Data  (Ignored)

        // Step 3: Send a Request
        Response response = given().spec(specification).when().get("/{users}");

        response.prettyPrint();


        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.hasSize(10));




    }
}
