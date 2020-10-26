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

    private AtomicInteger successCount = new AtomicInteger();

    private AtomicInteger FileIoCount = new AtomicInteger();


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

    @Override
    public String toString() {
        return "Counter{" +
                "totalCount=" + totalCount +
                ", failCount=" + failCount +
                ", executorCount=" + executorCount +
                ", successCount=" + successCount +
                ", FileIoCount=" + FileIoCount +
                '}';
    }
}
