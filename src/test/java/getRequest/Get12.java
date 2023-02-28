package getRequest;

import baseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get12 extends GorestBaseURL {

    /*


        Given
            https://gorest.co.in/public/v2/users/702440
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

    {
    "id": 702440,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}



     */

    @Test
    public void testGet12() {

        // step 1: set URL
        specification.pathParams("usersPath","users","idPath","702440");


        // Step 2: Set Expecter Data
        String expectedData ="{\n" +
                "    \"id\": 702440,\n" +
                "    \"name\": \"Adheesh Chopra\",\n" +
                "    \"email\": \"adheesh_chopra@schamberger-langosh.biz\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Object Mapper
        /*
        Object Mapper ı kullanabilmek için
        maven projeye pom.xml
        dependecy eklenmeli


         <dependency>
            <groupId>org.codehaus.jackson</groupId>
            <artifactId>jackson-mapper-asl</artifactId>
            <version>1.9.13</version>
        </dependency>

         */

        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");







    }
}
