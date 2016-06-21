package com.hzwl.videoview.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package com.meist.pinfan.model
 * 作 用：
 * 创建人：wxianing
 * 时 间：2016/6/12
 */

public class AppBean<T> implements Serializable {
    private int code;
    private int enumcode;
    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getEnumcode() {
        return enumcode;
    }

    public void setEnumcode(int enumcode) {
        this.enumcode = enumcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
