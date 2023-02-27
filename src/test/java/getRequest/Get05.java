package getRequest;

import baseURLs.TMDBAPIBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends TMDBAPIBaseURL {

    /*
    https://developers.themoviedb.org/3/authentication/create-request-token
        Given
            https://api.themoviedb.org/3/movie/popular


        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

key=412757644b659f89735e5b4910bd77df
     */


    @Test
    public void testGet05() {

        specification.pathParams("moviePath","movie",
                "popularPath","popular").queryParam("api_key","412757644b659f89735e5b4910bd77df");

        Response response = given().spec(specification).when().get("/{moviePath}/{popularPath}");

response.prettyPrint();

response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("results.id", Matchers.hasItems(646389,536554,640146));

    }
}
