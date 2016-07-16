package com.meist.pinfan.model;

import android.support.v4.app.Fragment;

/**
 * Package： com.meist.pinfan.model
 * Author： wxianing
 * 作  用：
 * 时  间： 2016/7/16
 */
public class Fragments {

    private Fragment fragment;

    private String title;

    public Fragments(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
