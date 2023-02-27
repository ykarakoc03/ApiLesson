package testData;

import java.util.HashMap;
import java.util.Objects;

public class JsonPlaceHolderTestData {

    public static HashMap<String,Object> expectedData;

    public HashMap setUpDataTodos(){

        /*
         {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}
         */
        expectedData = new HashMap<>();

        expectedData.put("StatusCode",200);
        expectedData.put("Server","cloudflare");
        expectedData.put("userId",1);
        expectedData.put("id",2.0);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        return expectedData;
    }



}
