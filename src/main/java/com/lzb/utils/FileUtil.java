package com.lzb.utils;

import com.lzb.bean.Counter;
import com.lzb.bean.ExcelRowData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LZB
 * @Date : 2020/10/23 14:58
 * @Description :
 */
public class FileUtil {

    public static void saveFile(String filePath, List<ExcelRowData> list, Counter counter) {

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath + Thread.currentThread().getName() + ".sql"), true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rows = 0;
        int ioCount = 0;
        for (ExcelRowData data : list) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("update `hc_user_center`.`t_uc_user` set channel_id = ");
                stringBuilder.append("'");
                stringBuilder.append(data.getNewOpenId());
                stringBuilder.append("'");
                stringBuilder.append(" where id = ");
                stringBuilder.append(data.getId().toString());
                stringBuilder.append(";");
                stringBuilder.append("\n");
                bufferedWriter.append(stringBuilder.toString());
                rows++;
                counter.getTotalCount().incrementAndGet();
                if (4 * 1024 == rows) {
                    bufferedWriter.flush();
                    ioCount++;
                    rows = 0;
                    counter.getFileIoCount().incrementAndGet();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.flush();
            ioCount++;
            counter.getFileIoCount().incrementAndGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " flush ioCount " + ioCount);


        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
