package com.artisan.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 11:13
 * @mark: show me the code , change the world
 */
public class FileExtract {


    public static void main(String[] args) {

       // String path = "D:\\BaiduNetdiskDownload\\极客专栏\\04-左耳听风";

        List<String> list = new ArrayList();
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\12-Linux性能优化实战");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\14-许式伟的架构课");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\79-消息队列高手课");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\83-编译原理之美");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\86-即时消息技术剖析与实战");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\88-高并发系统设计40问");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\90-分布式技术原理与算法解析");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\94-DDD实战课");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\101-后端技术面试38讲");
        list.add("D:\\BaiduNetdiskDownload\\极客专栏\\新建文件夹\\114-分布式协议与算法实战");


        list.stream().forEach(path ->{
            List<File> files = FileUtil.loopFiles(path);

            files.stream().filter(file -> file.getName().endsWith("html")).collect(Collectors.toList())
                    .forEach(f -> FileUtil.copy(f, new File(path), true));
        });



    }
}
    