package tests;

import config.GlobalParameters;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected Response response;

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = GlobalParameters.MAIN_URI;
        response = given().get(GlobalParameters.USERS_PATH).andReturn();
    }
}