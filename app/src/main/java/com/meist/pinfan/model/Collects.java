package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/22
 */
public class Collects implements Serializable {

    /**
     * PageIndex : 1
     * RecordCount : 13
     * DataList : [{"Id":117,"FKId":4,"FKType":3,"UserId":14,"CreateTime":"2016-06-22 17:47:04","Title":"相约南头美食街，相识是一种缘分","ThumbImg":"http://meist.meidp.com/upload/201606/56bd004cdf5f44f790c6e6a9fc008308.jpg","TotalCollect":24},{"Id":91,"FKId":3,"FKType":3,"UserId":14,"CreateTime":"2016-06-07 16:33:01","Title":"川菜桌","ThumbImg":"http://meist.meidp.com/upload/201606/428f57ee17fe409a9dd5252ba861bf54.jpg","TotalCollect":21},{"Id":90,"FKId":6,"FKType":3,"UserId":14,"CreateTime":"2016-06-07 16:32:28","Title":"休闲下午时光\u2014\u2014桌球","ThumbImg":"http://meist.meidp.com/upload/201606/44efc9ea184e491fad466bd34764c0eb.jpg","TotalCollect":4},{"Id":89,"FKId":6,"FKType":3,"UserId":14,"CreateTime":"2016-06-07 16:29:27","Title":"休闲下午时光\u2014\u2014桌球","ThumbImg":"http://meist.meidp.com/upload/201606/44efc9ea184e491fad466bd34764c0eb.jpg","TotalCollect":4},{"Id":88,"FKId":7,"FKType":3,"UserId":14,"CreateTime":"2016-06-06 17:30:58","Title":"相聚在保龄球的时光","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","TotalCollect":19},{"Id":87,"FKId":7,"FKType":3,"UserId":14,"CreateTime":"2016-06-04 16:12:00","Title":"相聚在保龄球的时光","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","TotalCollect":19},{"Id":86,"FKId":7,"FKType":3,"UserId":14,"CreateTime":"2016-06-04 16:11:58","Title":"相聚在保龄球的时光","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","TotalCollect":19},{"Id":85,"FKId":7,"FKType":3,"UserId":14,"CreateTime":"2016-06-04 16:11:56","Title":"相聚在保龄球的时光","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","TotalCollect":19},{"Id":84,"FKId":7,"FKType":3,"UserId":14,"CreateTime":"2016-06-04 16:11:35","Title":"相聚在保龄球的时光","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","TotalCollect":19},{"Id":83,"FKId":7,"FKType":3,"UserId":14,"CreateTime":"2016-06-04 16:11:01","Title":"相聚在保龄球的时光","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","TotalCollect":19}]
     */

    private int PageIndex;
    private int RecordCount;
    /**
     * Id : 117
     * FKId : 4
     * FKType : 3
     * UserId : 14
     * CreateTime : 2016-06-22 17:47:04
     * Title : 相约南头美食街，相识是一种缘分
     * ThumbImg : http://meist.meidp.com/upload/201606/56bd004cdf5f44f790c6e6a9fc008308.jpg
     * TotalCollect : 24
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

    public static class DataListBean {
        private int Id;
        private int FKId;
        private int FKType;
        private int UserId;
        private String CreateTime;
        private String Title;
        private String ThumbImg;
        private int TotalCollect;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getFKId() {
            return FKId;
        }

        public void setFKId(int FKId) {
            this.FKId = FKId;
        }

        public int getFKType() {
            return FKType;
        }

        public void setFKType(int FKType) {
            this.FKType = FKType;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getThumbImg() {
            return ThumbImg;
        }

        public void setThumbImg(String ThumbImg) {
            this.ThumbImg = ThumbImg;
        }

        public int getTotalCollect() {
            return TotalCollect;
        }

        public void setTotalCollect(int TotalCollect) {
            this.TotalCollect = TotalCollect;
        }
    }
}
