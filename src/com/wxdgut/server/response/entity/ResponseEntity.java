package com.wxdgut.server.response.entity;

/**
 * @author jiajian.yu
 * @program: NetStudy
 * @date 2022-10-20 14:33:42
 * Copyright (c) 2022 http://wxdgut.com
 * Email: hello_luyao@163.com
 * Profile:
 */
public class ResponseEntity {
    public String code = "0011";
    public String msg = "服务器发生异常";
    public String data = "{}";

    public ResponseEntity() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
