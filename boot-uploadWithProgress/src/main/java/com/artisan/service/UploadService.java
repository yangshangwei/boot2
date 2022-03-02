package com.artisan.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadService {

     Map<String, Object> getProgressStyle (String header);

     boolean getUploadDone(String header);

     void upload(MultipartFile[] file);
}
