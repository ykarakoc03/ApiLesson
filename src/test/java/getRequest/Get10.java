package getRequest;

import baseURLs.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get10 extends DummyBaseURL {

  /*

    Given
	   	   https://dummy.restapiexample.com/api/v1/employees

		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
            Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
            Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular



     */

    @Test
    public void get10() {
        /*
        1) Set URL
        2) Set Expected Data
        3) Send a request
        4) Assertion

         */

        // Step 1: SET URL
        //https://dummy.restapiexample.com/api/v1/employees

        specification.pathParam("employeesPath", "employees");

        //Step 2: Expected Data

        // Başka bir classta expected dataları setleyelim.

        DummyRestApiTestData dummyRestApiTestData = new DummyRestApiTestData();
        List<Map<String, Object>> expectedData = dummyRestApiTestData.setUpDummyRestTestData();

        System.out.println("Expected Data: " + expectedData);


        //Step 3: Send a request
        Response response = given().
                spec(specification).
                when().
                get("/{employeesPath}");

        response.prettyPrint();


        // Assertion

        // 1.Way:
        
        /*
        Then
			 Status Code un "200" olduğunu Assert et
		And
            Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
            Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
            Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular
         */
        response.then().assertThat().statusCode((Integer) expectedData.get(0).get("StatusCode")).
                body("data[-1].employee_name", equalTo(expectedData.get(1).get("EmployeeName")),
                        "data[5].employee_salary", equalTo(expectedData.get(2).get("EmployeeSalary")),
                        "data.employee_age", hasItems(((List) expectedData.get(3).get("EmployeeAges")).get(0),
                                ((List) expectedData.get(3).get("EmployeeAges")).get(1),
                                ((List) expectedData.get(3).get("EmployeeAges")).get(2)));

        
        /*

        // ugur hocanın employeeAges listesini bu şekilde uzun uzun yazmak yerine önerisi
        List <Integer> yasListesi = jsonPath.getList("data.employee_age");

        List<Integer> arananYaslar = Arrays.asList(21,23,61);

        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(arananYaslar));


         */

        // Homeworks:
        
        /*
        GSON
        JsonPath
        
        metotoalrını kullanarak assertion işlemlerini tamamlayınız .
         */


    }

}
