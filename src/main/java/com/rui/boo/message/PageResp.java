package com.rui.boo.message;

import com.rui.boo.exception.BizException;
import lombok.Data;

import java.util.List;

/**
 * @Author rui
 * @Date 2019-09-30 15:04
 **/
@Data
public class PageResp<T> {

    private int code;

    private String msg;

    private int count;

    private List<T> data;

    public PageResp(int count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public PageResp(BizException e) {
        this.code = 0;
        this.msg = e.getErrorDesc();
    }

    public PageResp(Message e) {
        this.code = 0;
        this.msg = e.getErrorDesc();
    }
}
