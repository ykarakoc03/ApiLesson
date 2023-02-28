package getRequest;

import baseURLs.ZipopotamBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.ZippoPotamPojos;
import pojoDatas.ZippoPotamsPlaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get11 extends ZipopotamBaseURL {
    /*


        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}

     */

    @Test
    public void testGet11() {
        // Step 1: SEt URL
        //http://api.zippopotam.us/TR/34010
        specification.pathParams("countryPath","TR","postCodePath","34010");


        //Step 2: Set Expected Data
        /*
         {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}
         */
        ZippoPotamsPlaces zippoPotamsPlaces = new ZippoPotamsPlaces("Maltepe Mah.","32.3609","İstanbul","34","40.1589");
        ZippoPotamPojos zippoPotamPojos = new ZippoPotamPojos("34010","Turkey","TR",zippoPotamsPlaces);


        //Step 3: Send a Request
        Response response = given().spec(specification).when().get("/{countryPath}/{postCodePath}");

        //Step 4: Assertion with GSON
        Map<String,Object> actualDataMap = response.as(HashMap.class);

        assertEquals(zippoPotamPojos.getCountry(),actualDataMap.get("country"));
        assertEquals(zippoPotamPojos.getPostCode(),actualDataMap.get("post code"));
        assertEquals(zippoPotamPojos.getCountryAbbreviation(),actualDataMap.get("country abbreviation"));
        assertEquals(zippoPotamPojos.getZippoPotamplaces().getPlaceName(),((Map)((List)actualDataMap.get("places")).get(0)).get("place name"));
        assertEquals(zippoPotamPojos.getZippoPotamplaces().getLongitude(),((Map)((List)actualDataMap.get("places")).get(0)).get("longitude"));
        assertEquals(zippoPotamPojos.getZippoPotamplaces().getState(),((Map)((List)actualDataMap.get("places")).get(0)).get("state"));
        assertEquals(zippoPotamPojos.getZippoPotamplaces().getStateAbbreviation(),((Map)((List)actualDataMap.get("places")).get(0)).get("state abbreviation"));
        assertEquals(zippoPotamPojos.getZippoPotamplaces().getLatitude(),((Map)((List)actualDataMap.get("places")).get(0)).get("latitude"));


    }
}
