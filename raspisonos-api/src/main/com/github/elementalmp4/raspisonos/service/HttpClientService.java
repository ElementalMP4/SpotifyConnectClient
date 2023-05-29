package main.com.github.elementalmp4.raspisonos.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class HttpClientService {

    private static final RequestBody EMPTY_REQUEST = RequestBody.create("", MediaType.parse("application/json"));

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.MILLISECONDS)
            .writeTimeout(1000, TimeUnit.MILLISECONDS)
            .build();

    public void post(String url) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .post(EMPTY_REQUEST)
                    .build();
            client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
