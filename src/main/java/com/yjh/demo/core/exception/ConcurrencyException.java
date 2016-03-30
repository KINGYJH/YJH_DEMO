package com.yjh.demo.core.exception;

/**
 *并发异常
 * Created by YJH on 2016/3/2.
 */
public class ConcurrencyException extends RuntimeException {
    public ConcurrencyException() {
    }

    public ConcurrencyException(String message) {
        super(message);
    }

    public ConcurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcurrencyException(Throwable cause) {
        super(cause);
    }
}
