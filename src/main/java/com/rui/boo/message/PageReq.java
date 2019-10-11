package com.rui.boo.message;

import lombok.Data;

/**
 * @Author rui
 * @Date 2019-09-30 15:03
 **/
@Data
public abstract class PageReq {

    // 查询页码
    private int page;

    // 查询记录数
    private int limit;

    // 起始记录
    private int offset;

    public int getOffset() {
        return (page - 1) * limit;
    }
}
