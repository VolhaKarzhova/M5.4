package tests.rest_assured_lib;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest {

    private static final String MAIN_URI = "https://jsonplaceholder.typicode.com";
    private static final String USERS_PATH = "/users";
    protected static final int SUCCESS_STATUS_CODE = 200;
    protected Response response;

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = MAIN_URI;
        response = given().get(USERS_PATH).andReturn();
    }
}