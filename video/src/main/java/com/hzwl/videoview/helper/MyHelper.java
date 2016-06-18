package com.hzwl.videoview.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Package com.kylin.testdemo
 * 作  用:
 * Author: wxianing
 * 时  间: 16/6/14
 */
public class MyHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS PERSON(_id iNTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR)";

    public MyHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
