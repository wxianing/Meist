package com.meist.pinfan.model;

import java.io.Serializable;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/21
 */
public class HotLists implements Serializable {

    /**
     * Name : 相聚在保龄球的时光
     * Id : 7
     * sTime : 2016-03-24 16:30:00
     * eTime : 2016-06-26 00:00:00
     * manPric : 200
     * femalePrice : 150
     * manSum : 4
     * femaleSum : 4
     * icon : http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg
     */

    private String Name;
    private int Id;
    private String sTime;
    private String eTime;
    private int manPric;
    private int femalePrice;
    private int manSum;
    private int femaleSum;
    private String icon;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSTime() {
        return sTime;
    }

    public void setSTime(String sTime) {
        this.sTime = sTime;
    }

    public String getETime() {
        return eTime;
    }

    public void setETime(String eTime) {
        this.eTime = eTime;
    }

    public int getManPric() {
        return manPric;
    }

    public void setManPric(int manPric) {
        this.manPric = manPric;
    }

    public int getFemalePrice() {
        return femalePrice;
    }

    public void setFemalePrice(int femalePrice) {
        this.femalePrice = femalePrice;
    }

    public int getManSum() {
        return manSum;
    }

    public void setManSum(int manSum) {
        this.manSum = manSum;
    }

    public int getFemaleSum() {
        return femaleSum;
    }

    public void setFemaleSum(int femaleSum) {
        this.femaleSum = femaleSum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
