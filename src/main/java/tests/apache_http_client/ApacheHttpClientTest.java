package tests.apache_http_client;

import business_objects.User;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApacheHttpClientTest extends BaseTest {

    private static final String CONTENT_TYPE_VALUE = "application/json; charset=utf-8";

    @Test(description = "verify an http status code")
    public void checkStatusCode() {
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, SUCCESS_STATUS_CODE, "Status code doesn't match expected");
    }

    @Test(description = "verify that content-type header exists in the obtained response")
    public void checkResponseHeaderHasContentType() {
        Header contentType = response.getEntity().getContentType();
        Assert.assertTrue(contentType != null, "Content-type is not in the header");
    }

    @Test(description = "verify the value of the content-type header", dependsOnMethods = "checkResponseHeaderHasContentType")
    public void checkContentTypeValueInResponseHeader() {
        String contentTypeValue = response.getEntity().getContentType().getValue();
        Assert.assertTrue(contentTypeValue.equalsIgnoreCase(CONTENT_TYPE_VALUE), "Content-type value of the response header doesn't match expected");
    }

    @Test(description = "verify the content of the response body")
    public void checkResponseBody() {
        String responseBody = httpClientService.getResponseBody(response);
        User[] users = httpClientService.getUsers(responseBody);
        Assert.assertEquals(users.length, 10, "Response body contains unexpected array of users");
    }
}