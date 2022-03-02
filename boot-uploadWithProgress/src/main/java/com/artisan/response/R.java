package com.artisan.response;

import lombok.Data;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/2 23:41
 * @mark: show me the code , change the world
 */
@Data
public class R  {

    /**
     * 结果状态 ,具体状态码参见ResponseCode
     */
    private int status;


    /**
     * 响应消息
     **/
    private String message;

    /**
     * 响应数据
     **/
    private Object data;



    /**
     * 成功
     *
     * @param 
     * @return
     */
    public static  R  ok() {
        R resultData = new R();
        resultData.setStatus(ResponseCode.RC100.getCode());
        resultData.setMessage(ResponseCode.RC100.getMessage());
        return new R();
    }

    /**
     * 成功
     *
     * @param 
     * @return
     */
    public static  R error(String message) {
        R resultData = new R();
        resultData.setStatus(ResponseCode.RC999.getCode());
        resultData.setMessage(message);
        return resultData;
    }



    public static  R data(Object message) {
        R resultData = new R();
        resultData.setStatus(ResponseCode.RC100.getCode());
        resultData.setMessage(ResponseCode.RC100.getMessage());
        resultData.setData(message);
        return resultData;
    }


}
    