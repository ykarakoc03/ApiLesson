package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseURL {


    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1").build();

    }

}
