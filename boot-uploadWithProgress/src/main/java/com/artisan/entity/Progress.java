package com.artisan.entity;

import lombok.Data;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/2 23:25
 * @mark: show me the code , change the world
 */

@Data
public class Progress implements Cloneable {

    private long bytesRead;
    private long contentLength;
    private long items;

    private static final Progress progress = new Progress();

    public static Progress getInstance() {
        return progress.clone();
    }

    @Override
    public Progress clone() {
        try {
            return (Progress) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}