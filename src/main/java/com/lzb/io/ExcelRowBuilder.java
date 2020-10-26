package com.lzb.io;

import com.lzb.bean.ExcelRowData;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : LZB
 * @Date : 2020/10/22 10:14
 * @Description :
 */
public class ExcelRowBuilder {


    public List<ExcelRowData> parseExcel(InputStream inputStream) throws IOException {
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(100)  //缓存到内存中的行数，默认是10
                .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(inputStream);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
        //遍历所有的行
        Sheet sheet = wk.getSheetAt(0);
        List<ExcelRowData> list = new ArrayList<>();
        for (Row row : sheet) {
            StringBuilder sb = new StringBuilder();
            //遍历所有的列
            ExcelRowData data = new ExcelRowData();
            try {
                data.setId(Long.valueOf(row.getCell(1).getStringCellValue()));
                data.setChannelId(row.getCell(2).getStringCellValue());
                list.add(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("list.size() = " + list.size());
        return list;
    }

}
