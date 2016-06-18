package com.meist.pinfan.utils;

import com.meist.pinfan.MyApplication;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class Constant {
    public static final String BASE_URL = "http://meistapi.meidp.com/";
    public static final String APPID = "102";
    //    public static final String CODE = SharedPreferencesUtils.getUser(MyApplication.getmInstance()).getCode();
    public static final String CODE = SharedPreferencesUtils.getStringData(MyApplication.getmInstance(), "CODE", null);
    public static final String LOGIN_URL = BASE_URL + "common/user/login";
    public static final String BANNER_URL = BASE_URL + "article/advertise/getlist";

    //菜系分类
    public static final String CLASSIFY_UTL = BASE_URL + "product/caixi/getsortlist";

    public static final String CLASSIFY_LIST_URL = BASE_URL + "product/caixi/getcaixilist";

    public static final String VIDEO_LIST_URL = BASE_URL + "common/file/getvideolist";
}
