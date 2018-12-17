package elsavier.main.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;



public class AppUtils {
    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;
    public static String defaultBaseURL = "http://www.google.com";

    //Sets Base URI
    public static void setBaseURI (String baseURL){
        RestAssured.baseURI = baseURL;
    }

    //Sets base path
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
        }

    //Reset base path
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }


    //Returns response by given path
    public static Response getResponseByPath(String path) {
        return get(path);
    }

    //Returns response
    public static Response getResponse() {
        return get();
    }

    //Returns JsonPath object
    public static JsonPath getJSonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
}
