package com.artisan.controller;

import com.artisan.response.R;
import com.artisan.response.ResponseData;
import com.artisan.service.UploadService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/2 23:29
 * @mark: show me the code , change the world
 *
 * https://www.toutiao.com/a7069649531197047335
 */

@RestController
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public R upload (MultipartFile[] file) {
        uploadService.upload(file);
        return R.ok();
    }

    @GetMapping("/progress")
    public R progress (HttpServletRequest request) {
        String file = request.getHeader("file");
        if (StringUtils.isEmpty(file)) {
            return R.error("需要 header: [file=xxx] 标识");

        }

        return R.data(uploadService.getProgressStyle(file));
    }
}
    