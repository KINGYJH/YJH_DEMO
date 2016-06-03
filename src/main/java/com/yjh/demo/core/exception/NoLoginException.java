package com.yjh.demo.core.exception;

/**
 * Created by YJH on 2016/4/19.
 */
public class NoLoginException extends RuntimeException {

    public NoLoginException() {
    }

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLoginException(Throwable cause) {
        super(cause);
    }

}
