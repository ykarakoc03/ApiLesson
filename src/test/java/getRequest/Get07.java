package getRequest;

import baseURLs.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends DummyBaseURL {
     /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And



     */

    @Test
    public void testGet07() {

        specification.pathParam("employeesPath", "employees");


        Response response = given().spec(specification).when().get("/{employeesPath}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        JsonPath jsonPath = response.jsonPath();

        List<Integer> employeeAges = jsonPath.getList("data.employee_age");
        System.out.println("employeeAges = " + employeeAges);

        int count = 0;
        for (Integer w : employeeAges) {
            if (w > 55) {
                count++;
            }
        }
        System.out.println("count = " + count);
        assertEquals(8, count);

        //alternatif
        /*
        int sayi = (int) employeeAges.stream().filter(t-> t>55).count();
        System.out.println("sayi = " + sayi);


         */

        //yazım şeklinin açıklaması için -> https://groovy-lang.org/closures.html
        //id si 17 den büyük olanların id lerini bu listin içine atıyoruz it lamptadaki t gibi.
        List<Integer> idS = jsonPath.getList("data.findAll{(it.id)>17}.id");
        System.out.println("idS = " + idS);

        assertEquals(7, idS.size());


        //salary si 100.000'den az olanları konsola yazdırınız.
        //Doris Wilder'ın bunlardan biri olduğunu assert ediniz.


        List<String> salaryNameList = jsonPath.getList("data.findAll{it.employee_salary<100000}.employee_name");


        System.out.println("salary map :" + salaryNameList);

        Collections.sort(salaryNameList);
        assertTrue(salaryNameList.contains("Doris Wilder"));


        List<String> deneme = jsonPath.getList("data.findAll{it.employee_salary<100000}");

        System.out.println(deneme);
        //cıktı: [{id=3, employee_name=Ashton Cox, employee_salary=86000, employee_age=66, profile_image=},
        // {id=11, employee_name=Jena Gaines, employee_salary=90560, employee_age=30, profile_image=},
        // {id=24, employee_name=Doris Wilder, employee_salary=85600, employee_age=23, profile_image=}]


        List<Map<String, Object>> employeeMap = jsonPath.getList("data");

        System.out.println(employeeMap);
        //cıktı: [{id=3, employee_name=Ashton Cox, employee_salary=86000, employee_age=66, profile_image=},
        // {id=11, employee_name=Jena Gaines, employee_salary=90560, employee_age=30, profile_image=},
        // {id=24, employee_name=Doris Wilder, employee_salary=85600, employee_age=23, profile_image=}]


    }

    }
