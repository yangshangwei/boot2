package com.artisan.handler;

import lombok.Data;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 公共结果
 * @mark: show me the code , change the world
 */
@Data
public class ResponseData<T> {

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
    private T data;

    /**
     * 接口请求时间
     **/
    private long timestamp;


    /**
     * 初始化，增加接口请求事件
     */
    public ResponseData() {
        this.timestamp = System.currentTimeMillis();
    }


    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> success() {
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setStatus(ResponseCode.RC100.getCode());
        resultData.setMessage(ResponseCode.RC100.getMessage());
        return resultData;
    }

    /**
     * 成功
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> success(String message) {
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setStatus(ResponseCode.RC100.getCode());
        resultData.setMessage(message);
        return resultData;
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setStatus(ResponseCode.RC100.getCode());
        resultData.setMessage(ResponseCode.RC100.getMessage());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 失败
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> fail(String message) {
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setStatus(ResponseCode.RC999.getCode());
        resultData.setMessage(message);
        return resultData;
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> fail(int code, String message) {
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> fail() {
        ResponseData<T> resultData = new ResponseData<>();
        resultData.setStatus(ResponseCode.RC999.getCode());
        resultData.setMessage(ResponseCode.RC999.getMessage());
        return resultData;
    }

}
