package com.lzb.factory;


import com.lzb.io.Resource;
import org.junit.Test;


/**
 * @Author : LZB
 * @Date : 2020/10/22 17:53
 * @Description :
 */

public class ExecutorTest {

    @Test
    public void executor() throws Exception {
        Executor executor = new ExecutorFactoryBuilder().builder(Resource.getInputStream("src/main/resources/change-openid.properties")).createExecutor();
        executor.handler();
    }
}
