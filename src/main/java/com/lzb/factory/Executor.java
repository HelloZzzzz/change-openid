package com.lzb.factory;

import com.lzb.bean.ExcelRowData;
import com.lzb.config.ChangeOpenidConfig;
import com.lzb.io.ChangeOpenidConfigBuilder;
import com.lzb.io.ExcelRowBuilder;
import com.lzb.io.Resource;

import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LZB
 * @Date : 2020/10/22 15:08
 * @Description :
 */
public interface Executor {

    void handler() throws Exception;


}
