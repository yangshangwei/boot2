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
public class SysFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 盘符路径
     */
    private String dirName;

    /**
     * 盘符类型
     */
    private String sysTypeName;

    /**
     * 文件类型
     */
    private String typeName;

    /**
     * 总大小
     */
    private String total;

    /**
     * 剩余大小
     */
    private String free;

    /**
     * 已经使用量
     */
    private String used;

    /**
     * 资源的使用率
     */
    private double usage;
}