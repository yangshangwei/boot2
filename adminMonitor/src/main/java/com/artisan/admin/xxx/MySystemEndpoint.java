package com.artisan.admin.xxx;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/30 20:24
 * @mark: show me the code , change the world
 */

@Configuration
@Endpoint(id = "mysystem", enableByDefault=true)
public class MySystemEndpoint {

    @ReadOperation
    public Map<String, Object> getMySystemInfo() {
        Map<String,Object> result= new HashMap<>();
        Map<String, String> map = System.getenv();
        result.put("username",map.get("USERNAME"));
        result.put("computername",map.get("COMPUTERNAME"));
        return result;
    }
}
    