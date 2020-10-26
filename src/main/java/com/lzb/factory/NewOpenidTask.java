package com.lzb.factory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzb.bean.Counter;
import com.lzb.bean.ExcelRowData;
import com.lzb.config.ChangeOpenidConfig;
import com.lzb.http.HttpPost;
import com.lzb.utils.FileUtil;
import com.lzb.utils.HttpUtil;
import com.lzb.utils.TokenUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LZB
 * @Date : 2020/10/22 15:09
 * @Description :
 */
public class NewOpenidTask implements Runnable {

    private Counter counter;

    private HttpPost httpPost = new HttpPost();

    private static final int COUNT = 100;


    private ChangeOpenidConfig config;


    //分段数据
    private List<ExcelRowData> list;

    private CountDownLatch countDownLatch;


    public NewOpenidTask(Counter counter, ChangeOpenidConfig config, List<ExcelRowData> list, CountDownLatch countDownLatch) {
        this.counter = counter;
        this.config = config;
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        this.getNewOpenId(config, list, httpPost, counter);
        Long mid = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " https接口耗时 " + (mid - start) + "ms");
        FileUtil.saveFile(config.getSqlFilePath(), list, counter);
        Long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " 保存文件 " + (end - mid) + "ms");
        countDownLatch.countDown();
    }


    private void getNewOpenId(ChangeOpenidConfig config, List<ExcelRowData> list, HttpPost httpPost, Counter counter) {
        String requestUrl = config.getChangeOpenIdUrl() + config.getToken();
        int index = 0;
        while (list.size() > index) {
            String post = HttpUtil.getRequestTencentPostBody(config.getFromAppId(), list.subList(index, index + COUNT > list.size() ? list.size() : index + COUNT));
            try {
                String response = httpPost.post(requestUrl, post);
                counter.getExecutorCount().incrementAndGet();
                JSONObject object = JSONObject.parseObject(response);
                //{"errcode":61004,"errmsg":"access clientip is not registered requestIP: 175.11.201.147 rid: 5f92a0c3-4b491949-0aa4f69d"}
                //{"errcode":0,"errmsg":"ok","result_list":[{"ori_openid":"ovRu5s6wF8eiH_tvVo6-9QDGVqYs","new_openid":"oFc1k1YbL_8OvBeuDtbKuXZB9WFY","err_msg":"ok"},{"ori_openid":"ovRu5s6wFkmWeozm6l6lvqLAwC9M","new_openid":"oFc1k1X4aokxFTlh6i00q4wz438w","err_msg":"ok"}]}
                if ("0".equals(object.getString("errcode")) && "ok".equals(object.getString("errmsg"))) {

                    JSONArray array = object.getJSONArray("result_list");
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject vo = array.getJSONObject(i);
                        //这个地方应该是同序的
                        ExcelRowData data = list.get(index + i);
                        if (vo.getString("ori_openid").equals(data.getChannelId())) {
                            data.setNewOpenId(vo.getString("new_openid"));
                            counter.getSuccessCount().incrementAndGet();
                        }
                    }
                } else {
                    //TODO 这个地方应该生成错误日志
                    if ("42001".equals(object.getString("errcode"))) {
                        //{"errcode":42001,"errmsg":"access_token expired rid: 5f96267c-6c0c2405-25a372af"}
                        TokenUtil.getToken(config);
                    }
                    System.out.println("response = " + response);
                    counter.getFailCount().incrementAndGet();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            index += COUNT;
        }
    }
}
