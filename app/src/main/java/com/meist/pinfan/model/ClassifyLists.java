package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/16
 */
public class ClassifyLists implements Serializable {

    private int PageIndex;
    private int RecordCount;
    /**
     * Name : 有菜有OPAID
     * Id : 7
     * sTime : 2016-03-24 12:12:00
     * eTime : 2016-06-30 00:00:00
     * manPric : 200
     * femalePrice : 150
     * manSum : 5
     * femaleSum : 5
     * icon : http://meist.meidp.com/upload/201603/95cf3ff244384c1f866e42944f46db84.jpg
     */

    private List<DataListBean> DataList;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(int RecordCount) {
        this.RecordCount = RecordCount;
    }

    public List<DataListBean> getDataList() {
        return DataList;
    }

    public void setDataList(List<DataListBean> DataList) {
        this.DataList = DataList;
    }

    public static class DataListBean implements Serializable {
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
}
