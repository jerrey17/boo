package com.rui.boo.controller;

import com.rui.boo.enums.ErrorEnums;
import com.rui.boo.exception.BizException;
import com.rui.boo.message.MessageBean;
import com.rui.boo.message.PageResp;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Supplier;

/**
 * @Author rui
 * @Date 2019-05-23 23:20
 **/
@Slf4j
public abstract class BasicController {

    public <T> MessageBean<T> supplier(Supplier<T> supplier) {
        try {
            T data = supplier.get();
            return new MessageBean<>(data);
        } catch (BizException e) {
            return new MessageBean(e);
        } catch (Exception e) {
            log.error("系统异常!", e);
            return new MessageBean(ErrorEnums.SYS_ERROR);
        }
    }

    public <T> PageResp<T> pageSupplier(Supplier<Integer> count, Supplier<List<T>> data) {
        try {
            int total = count.get();
            List<T> rows = data.get();
            return new PageResp(total, rows);
        } catch (BizException e) {
            return new PageResp(e);
        } catch (Exception e) {
            log.error("系统异常!", e);
            return new PageResp(ErrorEnums.SYS_ERROR);
        }
    }
}
