package com.lzb.http;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author : LZB
 * @Date : 2020/10/22 14:50
 * @Description :
 */

public class HttpPostTest {

    @Test
    public void post() throws IOException {
        HttpPost post = new HttpPost();
        String url = "https://api.weixin.qq.com/cgi-bin/changeopenid?access_token=38_yq93Y4OWx_n0VyH-TE5jYsREAJ7R7l9WWkkY8bWhWxZxbMPjVrF6uqvY9nx3hBGSgjEAh8J8K6-AV_mrzWfpKyKJ0gYnDA9oQw1zLQf94tCEVIOeG8Afje8ZqJg9qMsHPcBFyiePHoZiaCVxAZOiAFDVUJ";
        String json = "{\n" +
                "\"from_appid\":\"wx64cd895a47c844f5\",\n" +
                "\"openid_list\":[\"ovRu5s6wF8eiH_tvVo6-9QDGVqYs\",\"ovRu5s6wFkmWeozm6l6lvqLAwC9M\"]\n" +
                "}";
        System.out.println("post.post(url,json) = " + post.post(url, json));
    }
}
