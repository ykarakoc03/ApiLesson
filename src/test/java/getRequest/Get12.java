package getRequest;

import baseURLs.GorestBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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
     "id": 724790,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}



     */

    @Test
    public void testGet12() {

        // step 1: set URL
        specification.pathParams("usersPath","users","idPath","724790");


        // Step 2: Set Expecter Data
        String expectedData =" \"id\": 724790,\n" +
                "    \"name\": \"Adheesh Chopra\",\n" +
                "    \"email\": \"adheesh_chopra@schamberger-langosh.biz\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"";

        System.out.println("expectedData = " + expectedData);


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




        //1.yöntem pojo class ile
        GoRestCoApiPojo goRestCoApiPojo = JsonToJava.convertJsonToJavaObject(expectedData, GoRestCoApiPojo.class);
        System.out.println("goRestCoApiPojo = " + goRestCoApiPojo);

        // 2. yöntem direk Hash Map ile
        HashMap<String,Object> expectedDataMap =JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);


        //3.Step
        Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");


        //4.Step
                                             //bu sının                    verilen string yapısını  , bu classa cevirip geri veriyor
        HashMap<String,Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);


        assertEquals(expectedDataMap.get("gender"),actualDataMap.get("gender"));
        assertEquals(expectedDataMap.get("email"),actualDataMap.get("email"));
        assertEquals(expectedDataMap.get("name"),actualDataMap.get("name"));
        assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));
        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));




    }
}
