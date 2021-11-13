package com.artisan.enc;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/9 0:16
 * @mark: show me the code , change the world
 */
public class Base64Helper {

    /***
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryBASE64(String key) throws Exception{
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /***
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception{
        return (new BASE64Encoder()).encode(key);
    }


    public static void main(String[] args) throws Exception {

        String str = "artisan";
        // Base64加密
        System.out.println(encryptBASE64(str.getBytes()));
        // Base64解密
        System.out.println(new String(decryBASE64("YXJ0aXNhbg==") ));

    }
}
    