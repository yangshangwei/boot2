package com.artisan.resolver;

import com.artisan.listener.FileUploadListener;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/2 23:27
 * @mark: show me the code , change the world
 */

@Component
public class CustomMultipartResolver extends CommonsMultipartResolver {

    private final FileUploadListener fileUploadListener;

    public CustomMultipartResolver(FileUploadListener fileUploadListener) {
        this.fileUploadListener = fileUploadListener;
    }

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        // 设置上传监听器
        fileUpload.setProgressListener(fileUploadListener);
        try {
            List<FileItem> fileItems = ((ServletFileUpload)fileUpload).parseRequest(request);
            return this.parseFileItems(fileItems, encoding);
        } catch (FileUploadBase.SizeLimitExceededException var5) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), var5);
        } catch (FileUploadBase.FileSizeLimitExceededException var6) {
            throw new MaxUploadSizeExceededException(fileUpload.getFileSizeMax(), var6);
        } catch (FileUploadException var7) {
            throw new MultipartException("Failed to parse multipart servlet request", var7);
        }
    }
}