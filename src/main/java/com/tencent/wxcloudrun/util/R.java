package com.tencent.wxcloudrun.util;

import lombok.Data;

@Data
public class R {

    private Object message;

    public R(Object data) {
        message = data;
    }
}
