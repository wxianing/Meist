package com.meist.pinfan.utils;

/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class NullUtils {
    public static boolean isNull(String str) {
        if (str != null && !"".equals(str)) {
            return true;
        }
        return false;

    }
}
