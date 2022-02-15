package com.artisan.resp.v3;

import com.artisan.resp.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 拦截Controller方法的返回值，统一处理返回值/响应体
 * @mark: show me the code , change the world
 */

@RestControllerAdvice
public class CustomResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 处理String类型 
        if (o instanceof String) {
            return objectMapper.writeValueAsString(ResponseData.success(o));
        }
        // 若是统一返回类型，则不用再此封装
        if (o instanceof ResponseData) {
            return o;
        }
        return ResponseData.success(o);
    }
}
    