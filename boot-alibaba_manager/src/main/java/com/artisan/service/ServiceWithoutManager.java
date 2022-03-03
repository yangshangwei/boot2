package com.artisan.service;

import com.artisan.dao.UserDao;
import com.artisan.response.ResponseData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */


@Service
public class ServiceWithoutManager {

    private final boolean APP = true;

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Throwable.class)
    public ResponseData<String> buiz(Long idCard, Long name) {

        // 验证 1  假设  DB操作 校验
        String  var1 = doDBCheck1();

        // 验证 2  假设  DB操作 校验
        String  var2 =  doDBCheck2();

        // 业务  APP -- DB校验 --- 自动创建用户 -- 返回用户信息
        //      网页 -- DB校验 ---  -- 返回用户信息
        doBiz(var1,var2);

        return ResponseData.success("success");
    }

    @SneakyThrows
    private void doBiz(String a ,String b) {
        if(APP) {
            // 模拟业务耗时
            TimeUnit.MILLISECONDS.sleep(1200);
        }else {

        }
    }

    @SneakyThrows
    private String doDBCheck2() {
        // 模拟业务耗时
        TimeUnit.MILLISECONDS.sleep(500);
        return "";
    }

    @SneakyThrows
    private String doDBCheck1() {
        // 模拟业务耗时
        TimeUnit.MILLISECONDS.sleep(1000);
        return "";
    }


}
    