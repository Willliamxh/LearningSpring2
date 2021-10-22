package com.bjp.excep;

/**
 * @Author Willam_xh
 * @Date 2021-10-21 15:25
 * 自定义的运行时异常
 *
 */
public class NotEnoughException extends RuntimeException{
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
