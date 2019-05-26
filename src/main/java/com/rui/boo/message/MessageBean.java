package com.rui.boo.message;

import com.rui.boo.exception.BizException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageBean<T> {

    public static final int S = 1;
    public static final int F = 0;

    private int status = S;
    private String errorCode;
    private String errorDesc;
    private T data;

    public MessageBean() {}

    public MessageBean(T data) {
        this.data = data;
    }

    public MessageBean(BizException e) {
        this.status = F;
        this.errorCode = e.getErrorCode();
        this.errorDesc = e.getErrorDesc();
    }

    public MessageBean(Message e) {
        this.status = F;
        this.errorCode = e.getErrorCode();
        this.errorDesc = e.getErrorDesc();
    }

}
