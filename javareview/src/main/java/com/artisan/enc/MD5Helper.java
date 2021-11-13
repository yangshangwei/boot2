package com.artisan.enc;

import org.springframework.util.DigestUtils;


/**
 * @author 小工匠
 * @version 1.0
 * @description: 使用Spring自带的DigestUtils
 * @date 2021/11/9 0:24
 * @mark: show me the code , change the world
 */
public class MD5Helper {

    /**
     * MD5加密（生成唯一的MD5值）
     * @param str
     * @return
     */
    public static String md5BySpring(String str){
        return   DigestUtils.md5DigestAsHex(str.getBytes());

    }


    public static void main(String[] args) throws Exception {
        System.out.println(md5BySpring("artisan"));
    }
}
    