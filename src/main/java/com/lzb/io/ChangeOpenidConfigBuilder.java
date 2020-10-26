package com.lzb.io;

import com.lzb.config.ChangeOpenidConfig;
import com.lzb.utils.TokenUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author : LZB
 * @Date : 2020/10/22 19:48
 * @Description :
 */
public class ChangeOpenidConfigBuilder {

    private ChangeOpenidConfig changeOpenidConfig = new ChangeOpenidConfig();


    public ChangeOpenidConfig parseChangeOpenidConfig(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);

        changeOpenidConfig.setChangeSqlFilePathName(properties.getProperty("changeSqlFilePathName", "C:\\Users\\MACHENIKE\\Desktop\\"));
        changeOpenidConfig.setThreadCorePoolSize(Integer.valueOf(properties.getProperty("thread.threadNum", "4")));
        changeOpenidConfig.setExcelFilePath(properties.getProperty("excelFilePath"));


        changeOpenidConfig.setPlatformId(Long.parseLong(properties.getProperty("platformId")));
        changeOpenidConfig.setHisId(Long.parseLong(properties.getProperty("hisId")));
        changeOpenidConfig.setPlatformSource(Integer.valueOf(properties.getProperty("platformSource")));
        changeOpenidConfig.setSubSource(Integer.valueOf(properties.getProperty("subSource")));
        changeOpenidConfig.setGetTokenUrl(properties.getProperty("getTokenUrl"));
        changeOpenidConfig.setGeneralKey(properties.getProperty("GeneralKey"));
        changeOpenidConfig.setSqlFilePath(properties.getProperty("sqlFilePath"));
        changeOpenidConfig.setChangeOpenIdUrl(properties.getProperty("changeOpenIdUrl"));
        changeOpenidConfig.setFromAppId(properties.getProperty("fromAppId"));
        System.out.println("changeOpenidConfig.getFromAppId() = " + changeOpenidConfig.getFromAppId());
        TokenUtil.getToken(changeOpenidConfig);
        System.out.println("changeOpenidConfig.getToken() = " + changeOpenidConfig.getToken());

        //TODO 大文件应该配置懒加载
        loadExcel();
        inputStream.close();
        System.out.println("changeOpenidConfig = " + changeOpenidConfig);
        return this.changeOpenidConfig;
    }

    public void loadExcel() throws IOException {
        InputStream inputStream = Resource.getInputStream(changeOpenidConfig.getExcelFilePath());
        changeOpenidConfig.setDataList(new ExcelRowBuilder().parseExcel(inputStream));
        inputStream.close();
    }

}
