package com.lzb.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : LZB
 * @Date : 2020/10/22 10:00
 * @Description :
 */
public class Resource {
    public static InputStream getInputStream(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        return fileInputStream;
    }
}
