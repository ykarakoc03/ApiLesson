package getRequest;

import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class hw_jsonPlaceholder {

    @Test
    public void test01(){

//        https://jsonplaceholder.typicode.com/todos/2/*Status code is 200
//        And "completed" is false
//        And "userId" is
//        1 And "title" is "quis ut nam facilis et officia qui«
//        And header "Via" is "1.1 Vegur«
//        And header "Server" is "cloudflare«
//        And title is contains "qui«

        String URL = "https://jsonplaceholder.typicode.com/todos/2/";

        Response response = given().when().get(URL);

        System.out.println("RESPONSE: ");
        response.prettyPrint(); //prettyPrint()  syso gibidir.


        //Status code is 200
        response.then().assertThat().statusCode(200);

        //        And "completed" is false
        response.then().assertThat().body("completed",equalTo(false));

        //        And "userId" is
        response.then().assertThat().body("userId",equalTo(1));

        //        1 And "title" is "quis ut nam facilis et officia qui«
        response.then().assertThat().body("title",equalTo("quis ut nam facilis et officia qui"));

        //        And header "Via" is "1.1 Vegur«
        response.then().assertThat().header("Via","1.1 vegur");

        //        And header "Server" is "cloudflare«
        response.then().assertThat().header("Server","cloudflare");


        //        And title is contains "qui«
        response.then().assertThat().body("title",containsString("qui"));

    }





}
