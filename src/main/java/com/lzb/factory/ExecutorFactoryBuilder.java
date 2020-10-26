package com.lzb.factory;

import com.lzb.config.ChangeOpenidConfig;
import com.lzb.io.ChangeOpenidConfigBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : LZB
 * @Date : 2020/10/23 14:20
 * @Description :
 */
public class ExecutorFactoryBuilder {

    private ChangeOpenidConfig config;


    public ExecutorFactory builder(InputStream inputStream) throws IOException {
        this.config = new ChangeOpenidConfigBuilder().parseChangeOpenidConfig(inputStream);
        ExecutorFactory executorFactory = new DefaultExecutorFactory(config);
        return executorFactory;
    }




}
