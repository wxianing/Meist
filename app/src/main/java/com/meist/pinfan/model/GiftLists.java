package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package com.meist.pinfan.model
 * 作  用:
 * Author: wxianing
 * 时  间: 16/6/23
 */
public class GiftLists implements Serializable {

    /**
     * PageIndex : 1
     * RecordCount : 1
     * DataList : [{"CreateTime":"2016-03-23 12:18:18","FKId":3,"FKType":2,"FromUserId":0,"Id":4,"Price":12,"ProductEntityId":13,"ProductId":13,"Qty":1,"Status":2,"UserId":210,"ToUserId":225,"ChildId":6,"ProductName":"小狮子","SalePrice":800,"ThumbImg":"http://meist.meidp.com/upload/201603/ea49789b04ac4f029ef42fd9455a1cef.png","ProductStatus":1,"FromUserName":"系统赠送","ToUserName":"ios"}]
     */

    private int PageIndex;
    private int RecordCount;
    /**
     * CreateTime : 2016-03-23 12:18:18
     * FKId : 3
     * FKType : 2
     * FromUserId : 0
     * Id : 4
     * Price : 12
     * ProductEntityId : 13
     * ProductId : 13
     * Qty : 1
     * Status : 2
     * UserId : 210
     * ToUserId : 225
     * ChildId : 6
     * ProductName : 小狮子
     * SalePrice : 800
     * ThumbImg : http://meist.meidp.com/upload/201603/ea49789b04ac4f029ef42fd9455a1cef.png
     * ProductStatus : 1
     * FromUserName : 系统赠送
     * ToUserName : ios
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

    public static class DataListBean implements Serializable{
        private String CreateTime;
        private int FKId;
        private int FKType;
        private int FromUserId;
        private int Id;
        private int Price;
        private int ProductEntityId;
        private int ProductId;
        private int Qty;
        private int Status;
        private int UserId;
        private int ToUserId;
        private int ChildId;
        private String ProductName;
        private int SalePrice;
        private String ThumbImg;
        private int ProductStatus;
        private String FromUserName;
        private String ToUserName;

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
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

        public int getFromUserId() {
            return FromUserId;
        }

        public void setFromUserId(int FromUserId) {
            this.FromUserId = FromUserId;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getProductEntityId() {
            return ProductEntityId;
        }

        public void setProductEntityId(int ProductEntityId) {
            this.ProductEntityId = ProductEntityId;
        }

        public int getProductId() {
            return ProductId;
        }

        public void setProductId(int ProductId) {
            this.ProductId = ProductId;
        }

        public int getQty() {
            return Qty;
        }

        public void setQty(int Qty) {
            this.Qty = Qty;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public int getToUserId() {
            return ToUserId;
        }

        public void setToUserId(int ToUserId) {
            this.ToUserId = ToUserId;
        }

        public int getChildId() {
            return ChildId;
        }

        public void setChildId(int ChildId) {
            this.ChildId = ChildId;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public int getSalePrice() {
            return SalePrice;
        }

        public void setSalePrice(int SalePrice) {
            this.SalePrice = SalePrice;
        }

        public String getThumbImg() {
            return ThumbImg;
        }

        public void setThumbImg(String ThumbImg) {
            this.ThumbImg = ThumbImg;
        }

        public int getProductStatus() {
            return ProductStatus;
        }

        public void setProductStatus(int ProductStatus) {
            this.ProductStatus = ProductStatus;
        }

        public String getFromUserName() {
            return FromUserName;
        }

        public void setFromUserName(String FromUserName) {
            this.FromUserName = FromUserName;
        }

        public String getToUserName() {
            return ToUserName;
        }

        public void setToUserName(String ToUserName) {
            this.ToUserName = ToUserName;
        }
    }
}
