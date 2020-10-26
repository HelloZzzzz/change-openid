package com.lzb.config;

import com.lzb.bean.ExcelRowData;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @Author : LZB
 * @Date : 2020/10/22 19:39
 * @Description :
 */
public class ChangeOpenidConfig {
//    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();
//
//    //核心线程池大小,最大线程池大小,线程最大空闲时间,时间单位,线程等待队列,线程创建工厂,拒绝策略
//    private static ExecutorService pool = new ThreadPoolExecutor(5, 10,100L, TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

//    private Properties properties = new Properties();


    private int threadCorePoolSize;
    private int threadMaximumPoolSize;
    private long threadKeepAliveTime;
    private int threadUnit;
    private int threadThreadNum;
    private String changeSqlFilePathName;
    private String excelFilePath;


    private Long platformId;
    private Long hisId;
    private Integer platformSource;
    private Integer subSource;
    private String getTokenUrl;
    private String GeneralKey;
    private String token;

    private String sqlFilePath;

    private String fromAppId;
    private String changeOpenIdUrl;

    private List<ExcelRowData> dataList;

    public int getThreadCorePoolSize() {
        return threadCorePoolSize;
    }

    public void setThreadCorePoolSize(int threadCorePoolSize) {
        this.threadCorePoolSize = threadCorePoolSize;
    }

    public int getThreadMaximumPoolSize() {
        return threadMaximumPoolSize;
    }

    public void setThreadMaximumPoolSize(int threadMaximumPoolSize) {
        this.threadMaximumPoolSize = threadMaximumPoolSize;
    }

    public long getThreadKeepAliveTime() {
        return threadKeepAliveTime;
    }

    public void setThreadKeepAliveTime(long threadKeepAliveTime) {
        this.threadKeepAliveTime = threadKeepAliveTime;
    }

    public int getThreadUnit() {
        return threadUnit;
    }

    public void setThreadUnit(int threadUnit) {
        this.threadUnit = threadUnit;
    }

    public int getThreadThreadNum() {
        return threadThreadNum;
    }

    public void setThreadThreadNum(int threadThreadNum) {
        this.threadThreadNum = threadThreadNum;
    }

    public String getChangeSqlFilePathName() {
        return changeSqlFilePathName;
    }

    public void setChangeSqlFilePathName(String changeSqlFilePathName) {
        this.changeSqlFilePathName = changeSqlFilePathName;
    }

    public String getSqlFilePath() {
        return sqlFilePath;
    }

    public void setSqlFilePath(String sqlFilePath) {
        this.sqlFilePath = sqlFilePath;
    }

    public String getExcelFilePath() {
        return excelFilePath;
    }

    public void setExcelFilePath(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public String getGetTokenUrl() {
        return getTokenUrl;
    }

    public void setGetTokenUrl(String getTokenUrl) {
        this.getTokenUrl = getTokenUrl;
    }

    public String getGeneralKey() {
        return GeneralKey;
    }

    public void setGeneralKey(String generalKey) {
        GeneralKey = generalKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public Integer getSubSource() {
        return subSource;
    }

    public void setSubSource(Integer subSource) {
        this.subSource = subSource;
    }


    public String getFromAppId() {
        return fromAppId;
    }

    public void setFromAppId(String fromAppId) {
        this.fromAppId = fromAppId;
    }

    public String getChangeOpenIdUrl() {
        return changeOpenIdUrl;
    }

    public void setChangeOpenIdUrl(String changeOpenIdUrl) {
        this.changeOpenIdUrl = changeOpenIdUrl;
    }


    public List<ExcelRowData> getDataList() {
        return dataList;
    }

    public void setDataList(List<ExcelRowData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "ChangeOpenidConfig{" +
                "threadCorePoolSize=" + threadCorePoolSize +
                ", threadMaximumPoolSize=" + threadMaximumPoolSize +
                ", threadKeepAliveTime=" + threadKeepAliveTime +
                ", threadUnit=" + threadUnit +
                ", threadThreadNum=" + threadThreadNum +
                ", changeSqlFilePathName='" + changeSqlFilePathName + '\'' +
                ", excelFilePath='" + excelFilePath + '\'' +
                ", platformId=" + platformId +
                ", hisId=" + hisId +
                ", platformSource=" + platformSource +
                ", subSource=" + subSource +
                ", getTokenUrl='" + getTokenUrl + '\'' +
                ", GeneralKey='" + GeneralKey + '\'' +
                ", token='" + token + '\'' +
                ", sqlFilePath='" + sqlFilePath + '\'' +
                ", fromAppId='" + fromAppId + '\'' +
                ", changeOpenIdUrl='" + changeOpenIdUrl + '\'' +
                '}';
    }
}

