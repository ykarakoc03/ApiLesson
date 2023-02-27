package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class TMDBAPIBaseURL {

   protected RequestSpecification specification;

    @Before
    public void setUpBaseURL() {

        specification = new RequestSpecBuilder().setBaseUri("https://api.themoviedb.org/3").build();



    }
}
