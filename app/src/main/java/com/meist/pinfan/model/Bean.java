package com.meist.pinfan.model;

import java.io.Serializable;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/24
 */
public class Bean implements Serializable {
    private int code;
    private int enumcode;
    private String success;

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

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
