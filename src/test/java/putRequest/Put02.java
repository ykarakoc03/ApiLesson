package putRequest;

import baseURLs.HerokuBaseURL;
import org.junit.Test;

public class Put02 extends HerokuBaseURL {

  /*
        Given
	        1) https://restful-booker.herokuapp.com/booking/37
	        2) {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
        3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
            Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

            Cookie =>>> token=001832eb39ba0ca
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
     */


    @Test
    public void testPut02() {

        specification.pathParams("bookingPath","booking","idPath","37");


        //Set Expexted And Request Body




    }
}
