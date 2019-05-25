package com.rui.boo.exception;

import com.rui.boo.message.Message;

/**
 * @Author rui
 * @Date 2019-05-23 23:10
 **/
public class BizException extends RuntimeException implements Message {

    private String errorCode;

    private String errorDesc;

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDesc() {
        return errorDesc;
    }

    public BizException(Message message) {
        super(message.getErrorDesc());
        this.errorCode = message.getErrorCode();
        this.errorDesc = message.getErrorDesc();
    }

    public BizException(Message message, Throwable cause) {
        super(message.getErrorDesc(), cause);
        this.errorCode = message.getErrorCode();
        this.errorDesc = message.getErrorDesc();
    }

    public BizException(String message) {
        super(message);
        this.errorDesc = message;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.errorDesc = message;
    }

}
