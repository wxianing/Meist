package com.meist.pinfan.utils;

import com.meist.pinfan.MyApplication;

/**
 * Package：com.meist.pinfan.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
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

    public static final String CAIXI_DETAILS_URL = BASE_URL + "product/caixi/getcaixi";
    //首页热门
    public static final String HOME_HOTS_URL = BASE_URL + "product/caixi/gethotlist";

    public static final String UPDATE_PWD_URL = BASE_URL + "systemset/account/updatepassword";
}
