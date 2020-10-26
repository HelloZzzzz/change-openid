package com.lzb.io;

import com.lzb.config.ChangeOpenidConfig;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author : LZB
 * @Date : 2020/10/22 19:58
 * @Description :
 */

public class ChangeOpenidConfigBuilderTest {


    @Test
    public void parseChangeOpenidConfig() throws IOException {
        ChangeOpenidConfigBuilder builder = new ChangeOpenidConfigBuilder();
        String filePath = "src/main/resources/change-openid.properties";
        System.out.println(filePath);
        ChangeOpenidConfig changeOpenidConfig = builder.parseChangeOpenidConfig(Resource.getInputStream(filePath));
        System.out.println("changeOpenidConfig.getFromAppId() = " + changeOpenidConfig.getFromAppId());
    }
}
