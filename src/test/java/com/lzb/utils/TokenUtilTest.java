package com.lzb.utils;


import com.lzb.config.ChangeOpenidConfig;
import com.lzb.io.ChangeOpenidConfigBuilder;
import com.lzb.io.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author : LZB
 * @Date : 2020/10/23 10:21
 * @Description :
 */
public class TokenUtilTest {


    @Test
    public void getSign() {
    }

    @Test
    public void getToken() throws IOException {
        ChangeOpenidConfigBuilder changeOpenidConfigBuilder = new ChangeOpenidConfigBuilder();
        ChangeOpenidConfig changeOpenidConfig = changeOpenidConfigBuilder.parseChangeOpenidConfig(Resource.getInputStream("src/main/resources/change-openid.properties"));
        System.out.println("changeOpenidConfig.getToken() = " + changeOpenidConfig.getToken());
    }
}
