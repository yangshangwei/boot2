package com.artisan.service;

import com.artisan.dao.UserDao;
import com.artisan.response.ResponseData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/3 18:56
 * @mark: show me the code , change the world
 */
public class ServiceWithManager {



    @Autowired
    private UserDao userDao;

    @Autowired
    private BizManager bizManager;


   //  @Transactional(rollbackFor = Throwable.class)  去掉事务
    public ResponseData<String> buiz(Long idCard, Long name) throws InterruptedException {

        // 验证 1  假设  DB操作 校验
        String  var1 = doDBCheck1();

        // 验证 2  假设  DB操作 校验
        String  var2 =  doDBCheck2();

        // 业务 交给manager处理
        bizManager.doBiz(var1,var2);

        return ResponseData.success("success");
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
    