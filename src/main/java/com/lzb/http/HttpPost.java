package com.lzb.http;

import okhttp3.*;

import java.io.IOException;

/**
 * @Author : LZB
 * @Date : 2020/10/22 14:45
 * @Description :
 */
public class HttpPost {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    public String post(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

}
