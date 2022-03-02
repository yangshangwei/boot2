package com.artisan.listener;

import com.artisan.entity.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/2 23:26
 * @mark: show me the code , change the world
 */

@Component
public class FileUploadListener implements ProgressListener {

    private final Map<String, Progress> map = new ConcurrentHashMap<>();

    private final HttpServletRequest request;

    public FileUploadListener(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * @param bytesRead 当前上传大小
     * @param contentLength 总大小
     * @param items 当前上传个数
     */
    @Override
    public void update(long bytesRead, long contentLength, int items) {
        Progress progress = Progress.getInstance();
        progress.setBytesRead(bytesRead);
        progress.setContentLength(contentLength);
        progress.setItems(items);
        // 可替换成 redis / session
        map.put(request.getHeader("file"), progress);
    }

    public Progress getMap(String header) {
        return map.get(header);
    }
}