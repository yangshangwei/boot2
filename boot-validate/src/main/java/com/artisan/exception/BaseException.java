package com.artisan.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Base exception is the parent of all exceptions
 *
 * @author artisan
 */
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int errorCode;

    public BaseException(String errorMessage) {
        super(errorMessage);
    }

    public BaseException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public BaseException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }

    public BaseException(int errorCode, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
    }
}
