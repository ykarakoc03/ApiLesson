package postRequest;

import baseURLs.DummyBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.DummyRestApiPojo;
import pojoDatas.DummyRestApiExPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends DummyBaseURL {

  /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */

    @Test
    public void testPost03() {

        // Step 1) set url:
        specification.pathParam("createPath","create");


        //Step 2) Expected and Req
        DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo("Drake Fyi","40000","29");

        DummyRestApiExPojo dummyRestApiExPojo = new DummyRestApiExPojo("success",dummyRestApiPojo,"Successfully! Record has been added.");


        //Step 3) Send a request

        //Basic Auto. ---->kullanılacak
        //Dokümanda istemiyor. fakata biz nasıl kullanılacagını görmek için kullanacagız
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().
                basic("admin","password123").
                body(dummyRestApiPojo).
                when().
                post("/{createPath}");

        response.prettyPrint();



        //Step 4) Assert
        DummyRestApiExPojo actualData = response.as(DummyRestApiExPojo.class);
        System.out.println("Actual Data: " + actualData);

        assertEquals(dummyRestApiExPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyRestApiExPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyRestApiExPojo.getData().getName(), actualData.getData().getName());
        assertEquals(dummyRestApiExPojo.getData().getAge(),actualData.getData().getAge());
        assertEquals(dummyRestApiExPojo.getData().getSalary(),actualData.getData().getSalary());


    }
}
