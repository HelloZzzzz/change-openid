package com.lzb.bean;

/**
 * @Author : LZB
 * @Date : 2020/10/22 10:08
 * @Description :
 */
public class ExcelRowData {

    private Long id;

    private Long platformId;

    private String channelId;


    private String newOpenId;


    private String updateSql;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getNewOpenId() {
        return newOpenId;
    }

    public void setNewOpenId(String newOpenId) {
        this.newOpenId = newOpenId;
    }

    public String getUpdateSql() {
        return updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }

    @Override
    public String toString() {
        return "\"" + channelId + "\"";
    }


    public String forStringFor() {
        return "ExcelRowData{" +
                "id=" + id +
                ", platformId=" + platformId +
                ", channelId='" + channelId + '\'' +
                ", newOpenId='" + newOpenId + '\'' +
                ", updateSql='" + updateSql + '\'' +
                '}';
    }
}
