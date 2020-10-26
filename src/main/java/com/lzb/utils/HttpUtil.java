package com.lzb.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzb.bean.ExcelRowData;
import com.lzb.config.ChangeOpenidConfig;
import com.lzb.http.HttpPost;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LZB
 * @Date : 2020/10/23 15:58
 * @Description :
 */
public class HttpUtil {

    /**
     * 他妈的用fastJson 解析出来的格式腾讯那边会报错
     *
     * @param fromAppid
     * @param tempList
     * @return
     */
    public static String getRequestTencentPostBody(String fromAppid, List<ExcelRowData> tempList) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"from_appid\":\"");
        builder.append(fromAppid);
        builder.append("\"");
        builder.append(",\"openid_list\":");
        builder.append(tempList);
        builder.append("}");
//        System.out.println("requestBody = " + builder.toString());
        return builder.toString();
    }


}