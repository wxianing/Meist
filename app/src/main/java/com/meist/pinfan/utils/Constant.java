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
    //注册
    public static final String REGISTER_URL = BASE_URL + "common/user/register";

    //菜系分类
    public static final String CLASSIFY_UTL = BASE_URL + "product/caixi/getsortlist";

    public static final String CLASSIFY_LIST_URL = BASE_URL + "product/caixi/getcaixilist";

    public static final String VIDEO_LIST_URL = BASE_URL + "common/file/getvideolist";

    public static final String CAIXI_DETAILS_URL = BASE_URL + "product/caixi/getcaixi";
    //首页热门
    public static final String HOME_HOTS_URL = BASE_URL + "product/caixi/gethotlist";
    //修改密码
    public static final String UPDATE_PWD_URL = BASE_URL + "systemset/account/updatepassword";
    //重置密码
    public static final String FORGET_PASSWORD_URL = BASE_URL + "systemset/account/resetpassword";

    public static final int ENUMCODE = 1;
    //收藏
    public static final String COLLECT_URL = BASE_URL + "common/user/collect";

    public static final String GET_COLLECT_URL = BASE_URL + "common/user/getcollectlist";
    // 商家列表
    public static final String SHOP_LIST_URL = BASE_URL + "common/user/getshoplist";
    //店铺详情
    public static final String SHOP_DETAILS_URL = BASE_URL + "common/user/getshopinfo";
    //订单列表
    public static final String ORDER_LIST_URL = BASE_URL + "order/order/getorderlist";
    //订单详情
    public static final String ORDER_DETAILS_URL = BASE_URL + "order/order/getorder";
    //礼物列表
    public static final String GIFT_LIST_URL = BASE_URL + "common/user/giftlistajax";
    //好友列表
    public static final String FRIENDS_LIST_URL = BASE_URL + "common/user/getmyfriendlist";
    //获取礼物列表
    public static final String GIFT_LISTS_URL = BASE_URL + "product/product/getgiftlist";
    //发送礼物
    public static final String SEND_GIFT_URL = BASE_URL + "product/product/sendgift";
    //保存订单
    public static final String SAVE_ORDER_URL = BASE_URL + "order/order/ordersave";
    //修改个人信息
    public static final String UPDATE_MESSAGE = BASE_URL + "common/user/update";
    //红包列表
    public static final String RED_PACKAGE_LIST = BASE_URL + "common/user/getredpacketlist";

}
