package com.artisan.entity;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/24 15:15
 * @mark: show me the code , change the world
 */
import lombok.Data;
import java.io.Serializable;

@Data
public class Sys implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;
}