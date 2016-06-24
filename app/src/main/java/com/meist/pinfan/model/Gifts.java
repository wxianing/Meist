package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/24
 */
public class Gifts implements Serializable {

    /**
     * PageIndex : 1
     * RecordCount : 2
     * DataList : [{"ProductEntitys":[],"ProductBatchs":[],"MinAdvancePrice":0,"MinSalePrice":0,"Id":13,"SortId":0,"ProductName":"小狮子","ProductCode":"108832","Introduce":"<p>1231313<br/><\/p>","CycleDays":0,"CreateUserId":14,"CreateUserName":"admin","CreateTime":"2016-03-19 18:10:16","Status":1,"ThumbImg":"http://meist.meidp.com/upload/201603/ea49789b04ac4f029ef42fd9455a1cef.png","IsDeleted":0,"TotalRead":0,"TotalCollect":0,"Hits":0,"ReleaseTime":"2016-03-28 13:16:43","NeedBatchs":0,"AdvertImg":"","BuyMode":"","Mobile":"","SalePrice":800,"Category":2,"TotalComment":null},{"ProductEntitys":[],"ProductBatchs":[],"MinAdvancePrice":0,"MinSalePrice":0,"Id":12,"SortId":0,"ProductName":"测试礼品","ProductCode":"10001","Introduce":"","CycleDays":0,"CreateUserId":14,"CreateUserName":"admin","CreateTime":"2016-03-19 16:47:23","Status":1,"ThumbImg":"http://meist.meidp.com/upload/201603/c8c2a63980f04a559631c1484eccebe1.jpg","IsDeleted":0,"TotalRead":1,"TotalCollect":0,"Hits":0,"ReleaseTime":"2016-03-29 17:36:03","NeedBatchs":0,"AdvertImg":"","BuyMode":"","Mobile":"","SalePrice":36,"Category":2,"TotalComment":null}]
     */

    private int PageIndex;
    private int RecordCount;
    /**
     * ProductEntitys : []
     * ProductBatchs : []
     * MinAdvancePrice : 0
     * MinSalePrice : 0
     * Id : 13
     * SortId : 0
     * ProductName : 小狮子
     * ProductCode : 108832
     * Introduce : <p>1231313<br/></p>
     * CycleDays : 0
     * CreateUserId : 14
     * CreateUserName : admin
     * CreateTime : 2016-03-19 18:10:16
     * Status : 1
     * ThumbImg : http://meist.meidp.com/upload/201603/ea49789b04ac4f029ef42fd9455a1cef.png
     * IsDeleted : 0
     * TotalRead : 0
     * TotalCollect : 0
     * Hits : 0
     * ReleaseTime : 2016-03-28 13:16:43
     * NeedBatchs : 0
     * AdvertImg :
     * BuyMode :
     * Mobile :
     * SalePrice : 800
     * Category : 2
     * TotalComment : null
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
        private int MinAdvancePrice;
        private int MinSalePrice;
        private int Id;
        private int SortId;
        private String ProductName;
        private String ProductCode;
        private String Introduce;
        private int CycleDays;
        private int CreateUserId;
        private String CreateUserName;
        private String CreateTime;
        private int Status;
        private String ThumbImg;
        private int IsDeleted;
        private int TotalRead;
        private int TotalCollect;
        private int Hits;
        private String ReleaseTime;
        private int NeedBatchs;
        private String AdvertImg;
        private String BuyMode;
        private String Mobile;
        private int SalePrice;
        private int Category;
        private Object TotalComment;
        private List<?> ProductEntitys;
        private List<?> ProductBatchs;

        public int getMinAdvancePrice() {
            return MinAdvancePrice;
        }

        public void setMinAdvancePrice(int MinAdvancePrice) {
            this.MinAdvancePrice = MinAdvancePrice;
        }

        public int getMinSalePrice() {
            return MinSalePrice;
        }

        public void setMinSalePrice(int MinSalePrice) {
            this.MinSalePrice = MinSalePrice;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getSortId() {
            return SortId;
        }

        public void setSortId(int SortId) {
            this.SortId = SortId;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public String getProductCode() {
            return ProductCode;
        }

        public void setProductCode(String ProductCode) {
            this.ProductCode = ProductCode;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public int getCycleDays() {
            return CycleDays;
        }

        public void setCycleDays(int CycleDays) {
            this.CycleDays = CycleDays;
        }

        public int getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(int CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getThumbImg() {
            return ThumbImg;
        }

        public void setThumbImg(String ThumbImg) {
            this.ThumbImg = ThumbImg;
        }

        public int getIsDeleted() {
            return IsDeleted;
        }

        public void setIsDeleted(int IsDeleted) {
            this.IsDeleted = IsDeleted;
        }

        public int getTotalRead() {
            return TotalRead;
        }

        public void setTotalRead(int TotalRead) {
            this.TotalRead = TotalRead;
        }

        public int getTotalCollect() {
            return TotalCollect;
        }

        public void setTotalCollect(int TotalCollect) {
            this.TotalCollect = TotalCollect;
        }

        public int getHits() {
            return Hits;
        }

        public void setHits(int Hits) {
            this.Hits = Hits;
        }

        public String getReleaseTime() {
            return ReleaseTime;
        }

        public void setReleaseTime(String ReleaseTime) {
            this.ReleaseTime = ReleaseTime;
        }

        public int getNeedBatchs() {
            return NeedBatchs;
        }

        public void setNeedBatchs(int NeedBatchs) {
            this.NeedBatchs = NeedBatchs;
        }

        public String getAdvertImg() {
            return AdvertImg;
        }

        public void setAdvertImg(String AdvertImg) {
            this.AdvertImg = AdvertImg;
        }

        public String getBuyMode() {
            return BuyMode;
        }

        public void setBuyMode(String BuyMode) {
            this.BuyMode = BuyMode;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public int getSalePrice() {
            return SalePrice;
        }

        public void setSalePrice(int SalePrice) {
            this.SalePrice = SalePrice;
        }

        public int getCategory() {
            return Category;
        }

        public void setCategory(int Category) {
            this.Category = Category;
        }

        public Object getTotalComment() {
            return TotalComment;
        }

        public void setTotalComment(Object TotalComment) {
            this.TotalComment = TotalComment;
        }

        public List<?> getProductEntitys() {
            return ProductEntitys;
        }

        public void setProductEntitys(List<?> ProductEntitys) {
            this.ProductEntitys = ProductEntitys;
        }

        public List<?> getProductBatchs() {
            return ProductBatchs;
        }

        public void setProductBatchs(List<?> ProductBatchs) {
            this.ProductBatchs = ProductBatchs;
        }
    }
}
