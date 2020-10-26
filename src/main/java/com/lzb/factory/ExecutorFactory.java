package com.lzb.factory;

import java.io.FileNotFoundException;

/**
 * @Author : LZB
 * @Date : 2020/10/23 14:24
 * @Description :
 */
public interface ExecutorFactory {
    Executor createExecutor() throws Exception;
}
