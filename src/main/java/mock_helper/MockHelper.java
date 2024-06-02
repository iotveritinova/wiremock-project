package mock_helper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;

import java.util.HashSet;

import static io.restassured.RestAssured.given;

public class MockHelper {
    public static Response post(ObjectNode body, String url){
        return given().header("Content-Type","application/json").body(body).post(url);
    }

    public static void deleteMocks(HashSet<String> setForDelete){
        for (String s:setForDelete){
            given().delete(s);
        }
        setForDelete.clear();
    }
}

