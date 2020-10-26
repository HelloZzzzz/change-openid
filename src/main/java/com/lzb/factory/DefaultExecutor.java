package com.lzb.factory;

import com.lzb.bean.Counter;
import com.lzb.bean.ExcelRowData;
import com.lzb.config.ChangeOpenidConfig;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LZB
 * @Date : 2020/10/23 09:23
 * @Description :
 */
public class DefaultExecutor implements Executor {
    private ExecutorService executorService;


    private ChangeOpenidConfig config;

    private List<ExcelRowData> dataList;

    public DefaultExecutor(ChangeOpenidConfig config) {
        this.config = config;
        this.dataList = config.getDataList();
        this.executorService = Executors.newFixedThreadPool(config.getThreadCorePoolSize());
    }

    public void handler() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(config.getThreadCorePoolSize());


        int avgCount = dataList.size() % config.getThreadCorePoolSize() == 0 ? dataList.size() / config.getThreadCorePoolSize() : (dataList.size() / config.getThreadCorePoolSize() + 1);

        Counter counter = new Counter();

        List<ExcelRowData> tmpList;
        for (int i = 0; i < config.getThreadCorePoolSize(); i++) {
            tmpList = dataList.subList(i * avgCount, (i + 1) * avgCount > dataList.size() ? dataList.size() : (i + 1) * avgCount);
            executorService.execute(new NewOpenidTask(counter, config, tmpList, countDownLatch));
        }


        countDownLatch.await();
        executorService.shutdown();
        System.out.println("counter = " + counter);
        System.out.println("list.size() = " + dataList.size());

    }

}
