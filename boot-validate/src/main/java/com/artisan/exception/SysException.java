package com.artisan.exception;

/**
 * 已知的系统异常，需要记录Error日志，可以Retry
 *
 * @author artisan
 */
public class SysException extends BaseException {
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_ERROR_CODE = 540;

    public SysException(String errorMessage) {
        super(DEFAULT_ERROR_CODE, errorMessage);
    }

    public SysException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public SysException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }

    public SysException(int errorCode, String errorMessage, Throwable e) {
        super(errorCode, errorMessage, e);
    }
}
