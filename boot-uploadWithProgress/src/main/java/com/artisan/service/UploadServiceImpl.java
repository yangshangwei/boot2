package com.artisan.service;

import com.artisan.entity.Progress;
import com.artisan.exception.CustomException;
import com.artisan.listener.FileUploadListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/2 23:30
 * @mark: show me the code , change the world
 */

@Service
public class UploadServiceImpl implements UploadService {

    private final StringBuilder stringBuilder = new StringBuilder();

    private final Map<String, Object> map = new HashMap<>(4);

    // 构造注入上传监听
    private final FileUploadListener listener;

    public UploadServiceImpl(FileUploadListener listener) {
        this.listener = listener;
    }

    /**
     * 返回进度参数信息
     *         "progress": "[##########] 100%",
     *         "item": 3,
     *         "percent": 100,
     *         "status": "over"
     * @param header 文件标识
     * @return Map<String, Object>
     */
    // 进度 Map
    @Override
    public Map<String, Object> getProgressStyle (String header) {
        Progress progress = listener.getMap(header);
        if (progress == null) throw new CustomException("未上传文件");

        long read = progress.getBytesRead();
        long percent = 0;
        if (read != 0) percent = (read * 100) / progress.getContentLength();
        map.put("percent", percent);
        map.put("status", percent == 100 ? "over" : "active");
        map.put("progress", getStyleOfCount(percent));
        map.put("item", progress.getItems());
        return map;
    }

    /**
     * 判断文件是否上传文成
     * @param header 文件标识
     * @return true / false
     */
    @Override
    public boolean getUploadDone(String header) {
        Progress progress = listener.getMap(header);
        if (progress == null) {
            throw new CustomException("未上传文件");
        }

        return progress.getBytesRead() == progress.getContentLength();
    }

    /**
     * 文件保存操作
     * 这里做存储文件等其他操作操作
     * 这里也需要返回进度的话，上面的进度需要 / 2，各记 50%
     * @param file 文件
     */
    @Override
    public void upload(MultipartFile[] file) {
        Arrays.asList(file).forEach(f -> {
            if (f.isEmpty()) {
                throw new CustomException("文件为空");
            } else {
                System.out.println("文件名：" + f.getOriginalFilename());
                System.out.println("文件大小：" + f.getSize());
                System.out.println("文件类型：" + f.getContentType());
            }
        });
    }

    /**
     * 进度样式
     * @param percent 进度百分比
     * @return [###       ] 30%
     */
    private String getStyleOfCount (long percent) {
        stringBuilder.setLength(0);
        stringBuilder.append("[");
        for (int i = 0; i < percent / 10; i++) {
            stringBuilder.append("#");
        }
        for (int i = 0; i < 10 - (percent / 10); i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("] ").append(percent).append("%");
        return stringBuilder.toString();
    }
}