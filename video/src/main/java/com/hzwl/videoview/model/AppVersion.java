package com.hzwl.videoview.model;

import java.io.Serializable;

/**
 * Package：com.hzwl.videoview.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/20
 */
public class AppVersion<T> implements Serializable {

    private int code;
    private int enumcode;
    private String msg;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

}
