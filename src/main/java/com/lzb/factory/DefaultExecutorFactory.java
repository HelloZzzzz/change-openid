package com.lzb.factory;

import com.lzb.bean.ExcelRowData;
import com.lzb.config.ChangeOpenidConfig;
import com.lzb.io.ExcelRowBuilder;
import com.lzb.io.Resource;
import com.lzb.utils.TokenUtil;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : LZB
 * @Date : 2020/10/23 14:31
 * @Description :
 */
public class DefaultExecutorFactory implements ExecutorFactory {

    private ChangeOpenidConfig config;


    public DefaultExecutorFactory(ChangeOpenidConfig config) {
        this.config = config;
    }

    @Override
    public Executor createExecutor() throws Exception {

        return new DefaultExecutor(config);
    }

}
