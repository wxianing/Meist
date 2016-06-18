package com.hzwl.videoview.model;

import android.content.Context;

import com.hzwl.videoview.helper.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Package com.kylin.testdemo.bean
 * 作  用:
 * Author: wxianing
 * 时  间: 16/6/14
 */

public class UserDao {
    private Context context;
    private Dao<User, Integer> userDaoOpen;
    private DatabaseHelper helper;

    public UserDao(Context context) {
        this.context = context;
        helper = DatabaseHelper.getHelper(context);
        try {
            userDaoOpen = helper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        try {
            userDaoOpen.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User queryById(int id) {
        User user = null;
        try {
            user = userDaoOpen.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> queryAll() {
        List<User> userList = null;
        try {
            userList = userDaoOpen.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
