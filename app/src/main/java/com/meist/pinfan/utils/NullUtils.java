package com.meist.pinfan.utils;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
public class NullUtils {
    public static boolean isNull(String str) {
        if (str != null && !"".equals(str)) {
            return true;
        }
        return false;

    }
}
