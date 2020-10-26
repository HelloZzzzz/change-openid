package com.lzb.io;


import com.lzb.bean.ExcelRowData;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : LZB
 * @Date : 2020/10/22 10:38
 * @Description :
 */
public class ExcelRowBuilderTest {

    @Test
    public void parseExcel() throws IOException {
        ExcelRowBuilder builder = new ExcelRowBuilder();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "\\platformidtest.xlsx";
        assert null != builder.parseExcel(Resource.getInputStream(filePath)) ;
    }
}