package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import users.User;

public class RestAssuredTest extends BaseTest {

    private static final String CONTENT_TYPE_VALUE = "application/json; charset=utf-8";
    private static final int SUCCESS_STATUS_CODE = 200;

    @Test(description = "verify an http status code")
    public void checkStatusCode() {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, SUCCESS_STATUS_CODE, "Status code doesn't match expected");
    }

    @Test(description = "verify that content-type header exists in the obtained response")
    public void checkResponseHeaderHasContentType() {
        String contentType = response.contentType();
        Assert.assertFalse(contentType.isEmpty(), "Response doesn't have Content-Type");
    }

    @Test(description = "verify the value of the content-type header")
    public void checkContentTypeValueInResponseHeader() {
        String valueOfContentTypeHeader = response.getContentType();
        Assert.assertTrue(valueOfContentTypeHeader.equalsIgnoreCase(CONTENT_TYPE_VALUE),
                "Content-type value of the response header doesn't match expected");
    }

    @Test(description = "verify the content of the response body")
    public void checkResponseBody() {
        User[] users = response.as(User[].class);
        Assert.assertEquals(users.length, 10, "Response body contains unexpected array of users");
    }
}