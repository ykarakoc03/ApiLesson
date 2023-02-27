package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuBaseURL {

    protected RequestSpecification specification;

    @Before
    public void setUpURL(){

    specification = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }
}
