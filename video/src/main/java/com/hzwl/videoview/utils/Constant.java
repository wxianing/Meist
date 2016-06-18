package com.hzwl.videoview.utils;

import android.os.Environment;
import android.os.ParcelUuid;

import java.io.File;

/**
 * Created by Administrator on 2016/6/15.
 */
public class Constant {

    public static final String BASE_URL = "http://meistapi.meidp.com/";

    public static final String DOWNLOAD_VIDEO_URL = BASE_URL + "common/file/getvideolist";

    public static final int SUCCESS = 0;

    public static final String VERSION_NAME = "versionName";
    // action
    public static final String ACTION_NEW_VERSION = "com.meten.ifuture.ACTION_NEW_VERSION";

    public static final String BASE_DIR = Environment.getExternalStorageDirectory() + File.separator + "meist" + File.separator;

    public static final String FILE_DIR = BASE_DIR + "Video" + File.separator;

    public static final String LOGIN_UTL = BASE_URL+"common/user/login";

}
