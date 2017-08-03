package tests.apache_http_client;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static final int SUCCESS_STATUS_CODE = 200;
    protected HttpClientService httpClientService = new HttpClientService();
    protected CloseableHttpResponse response;

    @BeforeTest
    public void getResponse() {
        response = httpClientService.getResponse();
    }
}