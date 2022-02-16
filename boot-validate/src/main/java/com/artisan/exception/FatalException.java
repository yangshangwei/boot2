package com.artisan.exception;

/**
 * 严重的错误异常，需要记录Error日志，接入告警系统
 *
 * @author artisan
 */
public class FatalException extends BaseException {
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_ERROR_CODE = 580;

    public FatalException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage);
    }

    public FatalException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public FatalException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }

    public FatalException(int errorCode, String errorMessage, Throwable e) {
        super(errorCode, errorMessage, e);
    }
}
