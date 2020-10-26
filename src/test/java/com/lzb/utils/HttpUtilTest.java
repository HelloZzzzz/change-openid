package com.lzb.utils;

import com.lzb.bean.ExcelRowData;
import com.lzb.config.ChangeOpenidConfig;
import com.lzb.factory.*;
import com.lzb.http.HttpPost;
import com.lzb.io.ChangeOpenidConfigBuilder;
import com.lzb.io.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.security.auth.login.Configuration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @Author : LZB
 * @Date : 2020/10/23 16:25
 * @Description :
 */

public class HttpUtilTest {

    private ChangeOpenidConfig config;


    @Before
    public void before() throws IOException {
        this.config = new ChangeOpenidConfigBuilder()
                .parseChangeOpenidConfig(Resource.getInputStream("src/main/resources/change-openid.properties"));
    }


    @Test
    public void getNewOpenId() throws Exception {
//        HttpUtil.getNewOpenId(config, config.getDataList().subList(11080, 11090), new HttpPost(),new AtomicInteger());
//        for (ExcelRowData data : config.getDataList().subList(11080, 11090)) {
//            System.out.println("data = " + data.forString());
//        }
    }


    @Test
    public void getRequestTencentPostBody() throws IOException {
        HttpUtil.getRequestTencentPostBody(config.getFromAppId(), config.getDataList().subList(50, 60));
    }


}
