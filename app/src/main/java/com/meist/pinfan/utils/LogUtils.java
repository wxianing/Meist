package com.meist.pinfan.utils;

import android.util.Log;

import com.meist.pinfan.BuildConfig;

public class LogUtils {
	private static final String TAG = "Meist";

	public static void e(String msg) {
		e(TAG, msg);
	}

	public static void i(String msg) {
		i(TAG, msg);
	}

	public static void d(String msg) {
		d(TAG, msg);
	}

	public static void v(String msg) {
		v(TAG, msg);
	}

	public static void w(String msg) {
		w(TAG, msg);
	}

	public static void e(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			Log.e(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			Log.i(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void v(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			Log.v(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			Log.w(tag, msg);
		}
	}
}
