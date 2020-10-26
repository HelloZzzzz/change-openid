package com.lzb.bean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LZB
 * @Date : 2020/10/22 12:56
 * @Description :
 */
public class Counter {

    private AtomicInteger totalCount = new AtomicInteger();

    private AtomicInteger failCount = new AtomicInteger();

    private AtomicInteger executorCount = new AtomicInteger();

    private AtomicInteger executorFailCount = new AtomicInteger();

    private AtomicInteger successCount = new AtomicInteger();

    private AtomicInteger FileIoCount = new AtomicInteger();

    private AtomicInteger ignoreWriterFile = new AtomicInteger();

    private AtomicInteger saveFileCount = new AtomicInteger();

    public AtomicInteger getTotalCount() {
        return totalCount;
    }

    public AtomicInteger getFailCount() {
        return failCount;
    }

    public AtomicInteger getExecutorCount() {
        return executorCount;
    }

    public AtomicInteger getSuccessCount() {
        return successCount;
    }

    public AtomicInteger getFileIoCount() {
        return FileIoCount;
    }

    public AtomicInteger getExecutorFailCount() {
        return executorFailCount;
    }

    public AtomicInteger getIgnoreWriterFile() {
        return ignoreWriterFile;
    }

    public AtomicInteger getSaveFileCount() {
        return saveFileCount;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "总处理条数=" + totalCount +
                ", 失败条数=" + failCount +
                ", 调用接口次数=" + executorCount +
                ", 调用接口失败次数=" + executorFailCount +
                ", 成功条数=" + successCount +
                ", IO次数=" + FileIoCount +
                ", 忽略写文件条数=" + ignoreWriterFile +
                ", 写文件条数=" + saveFileCount +
                '}';
    }
}
