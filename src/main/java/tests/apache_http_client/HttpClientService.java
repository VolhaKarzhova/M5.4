package tests.apache_http_client;


import business_objects.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;

public class HttpClientService {

    private static final String MAIN_URI = "https://jsonplaceholder.typicode.com";
    private static final String USERS_PATH = "/users";
    private static final String EMPTY_STRING = "";
    private CloseableHttpResponse response;
    private Type itemsArrType = new TypeToken<User[]>() {
    }.getType();

    public CloseableHttpResponse getResponse() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(MAIN_URI + USERS_PATH);
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
        }
        return response;
    }

    public User[] getUsers(String jsonFile) {
        return new Gson().fromJson(jsonFile, itemsArrType);
    }

    public String getResponseBody(CloseableHttpResponse response) {
        try {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
        }
        return EMPTY_STRING;
    }
}