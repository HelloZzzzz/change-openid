package com.lzb.io;

import com.lzb.bean.ExcelRowData;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.swing.filechooser.FileSystemView;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : LZB
 * @Date : 2020/10/22 10:49
 * @Description :
 */
public class ResourceTest {

    @Test
    public void getInputStream() throws FileNotFoundException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "\\user.xlsx";
        System.out.println(filePath);
        assert Resource.getInputStream(filePath) != null;
    }


    @Test
    public void getInputStream1() throws FileNotFoundException {
        String filePath = "src/main/resources/change-openid.properties";
        System.out.println(filePath);
        assert Resource.getInputStream(filePath) != null;
    }
}
