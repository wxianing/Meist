package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/23
 */
public class Order implements Serializable {

    /**
     * PageIndex : 1
     * RecordCount : 4
     * DataList : [{"OrderBatchs":[],"MaxNumber":0,"BatchStatus":0,"StatusName":null,"Id":118,"OrderNo":"2016060004","CreateTime":"2016-06-12 11:27:02","Address":"微信支付","PayStyle":0,"Status":3,"PayState":0,"TotalMoney":null,"UserId":14,"PayTime":null,"IsComment":null,"IsCommentReply":null,"CXNumber":null,"DisCount":null,"OrderDate":null,"UserCardMoney":null,"UserCardId":null,"Price":200,"ProductId":2,"Qty":1,"ProductEntityId":7,"GradeId":0,"ProductModel":"1","ProductName":"购物公园店欢迎您的光临","ProductCode":"1","SortId":1,"UserName":"admin","ThumbImg":"http://meist.meidp.com/upload/201606/40f5944a368e4b9683a928334f9f2a84.jpg","SortName":"川湘菜组合","DetailID":118,"NeedBatchs":0},{"OrderBatchs":[],"MaxNumber":0,"BatchStatus":0,"StatusName":null,"Id":117,"OrderNo":"2016060003","CreateTime":"2016-06-12 11:25:38","Address":"微信支付","PayStyle":0,"Status":3,"PayState":0,"TotalMoney":null,"UserId":14,"PayTime":null,"IsComment":null,"IsCommentReply":null,"CXNumber":null,"DisCount":null,"OrderDate":null,"UserCardMoney":null,"UserCardId":null,"Price":200,"ProductId":7,"Qty":2,"ProductEntityId":2,"GradeId":0,"ProductModel":null,"ProductName":"相聚在保龄球的时光","ProductCode":null,"SortId":2,"UserName":"admin","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","SortName":null,"DetailID":117,"NeedBatchs":0},{"OrderBatchs":[],"MaxNumber":0,"BatchStatus":0,"StatusName":null,"Id":116,"OrderNo":"2016060002","CreateTime":"2016-06-12 09:57:01","Address":"微信支付","PayStyle":0,"Status":3,"PayState":0,"TotalMoney":null,"UserId":14,"PayTime":null,"IsComment":null,"IsCommentReply":null,"CXNumber":null,"DisCount":null,"OrderDate":null,"UserCardMoney":null,"UserCardId":null,"Price":200,"ProductId":6,"Qty":1,"ProductEntityId":1,"GradeId":0,"ProductModel":null,"ProductName":"休闲下午时光\u2014\u2014桌球","ProductCode":null,"SortId":2,"UserName":"admin","ThumbImg":"http://meist.meidp.com/upload/201606/44efc9ea184e491fad466bd34764c0eb.jpg","SortName":null,"DetailID":116,"NeedBatchs":0},{"OrderBatchs":[],"MaxNumber":0,"BatchStatus":0,"StatusName":null,"Id":115,"OrderNo":"2016060001","CreateTime":"2016-06-12 09:52:14","Address":"微信支付","PayStyle":0,"Status":3,"PayState":0,"TotalMoney":null,"UserId":14,"PayTime":null,"IsComment":null,"IsCommentReply":null,"CXNumber":null,"DisCount":null,"OrderDate":null,"UserCardMoney":null,"UserCardId":null,"Price":200,"ProductId":7,"Qty":2,"ProductEntityId":1,"GradeId":0,"ProductModel":null,"ProductName":"相聚在保龄球的时光","ProductCode":null,"SortId":2,"UserName":"admin","ThumbImg":"http://meist.meidp.com/upload/201606/5101d4bcd2a5436c84cfb56e39b8be16.jpg","SortName":null,"DetailID":115,"NeedBatchs":0}]
     */

    private int PageIndex;
    private int RecordCount;
    /**
     * OrderBatchs : []
     * MaxNumber : 0
     * BatchStatus : 0
     * StatusName : null
     * Id : 118
     * OrderNo : 2016060004
     * CreateTime : 2016-06-12 11:27:02
     * Address : 微信支付
     * PayStyle : 0
     * Status : 3
     * PayState : 0
     * TotalMoney : null
     * UserId : 14
     * PayTime : null
     * IsComment : null
     * IsCommentReply : null
     * CXNumber : null
     * DisCount : null
     * OrderDate : null
     * UserCardMoney : null
     * UserCardId : null
     * Price : 200
     * ProductId : 2
     * Qty : 1
     * ProductEntityId : 7
     * GradeId : 0
     * ProductModel : 1
     * ProductName : 购物公园店欢迎您的光临
     * ProductCode : 1
     * SortId : 1
     * UserName : admin
     * ThumbImg : http://meist.meidp.com/upload/201606/40f5944a368e4b9683a928334f9f2a84.jpg
     * SortName : 川湘菜组合
     * DetailID : 118
     * NeedBatchs : 0
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

        /**
         * SortName : null
         * CXNumber : null
         * UserName : ios
         * ProductModel : null
         * ProductEntityId : 9
         * Qty : 1
         * GradeId : 0
         * PayTime : null
         * OrderNo : 2016060022
         * MaxNumber : 0
         * DisCount : null
         * IsCommentReply : null
         * PayState : 0
         * StatusName : null
         * ProductName : 港式茶餐厅
         * UserCardMoney : null
         * TotalMoney : 30
         * UserCardId : null
         * OrderDate : 2016-06-30 00:00:00
         * ProductCode : null
         * NeedBatchs : 0
         * OrderBatchs : []
         * ThumbImg : http://meist.meidp.com/upload/201606/a6d87ba613fd49cda7886f76233d3ee4.jpg
         * BatchStatus : 0
         * UserId : 210
         * IsComment : null
         * ProductId : 9
         * Status : 3
         * SortId : 3
         * Price : 30
         * Address : null
         * CreateTime : 2016-06-23 14:30:32
         * PayStyle : 0
         * Id : 136
         * DetailID : 136
         */

        private Object SortName;
        private Object CXNumber;
        private String UserName;
        private Object ProductModel;
        private int ProductEntityId;
        private int Qty;
        private int GradeId;
        private Object PayTime;
        private String OrderNo;
        private int MaxNumber;
        private Object DisCount;
        private Object IsCommentReply;
        private int PayState;
        private Object StatusName;
        private String ProductName;
        private Object UserCardMoney;
        private int TotalMoney;
        private Object UserCardId;
        private String OrderDate;
        private Object ProductCode;
        private int NeedBatchs;
        private String ThumbImg;
        private int BatchStatus;
        private int UserId;
        private Object IsComment;
        private int ProductId;
        private int Status;
        private int SortId;
        private int Price;
        private Object Address;
        private String CreateTime;
        private int PayStyle;
        private int Id;
        private int DetailID;
        private List<?> OrderBatchs;

        public Object getSortName() {
            return SortName;
        }

        public void setSortName(Object SortName) {
            this.SortName = SortName;
        }

        public Object getCXNumber() {
            return CXNumber;
        }

        public void setCXNumber(Object CXNumber) {
            this.CXNumber = CXNumber;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public Object getProductModel() {
            return ProductModel;
        }

        public void setProductModel(Object ProductModel) {
            this.ProductModel = ProductModel;
        }

        public int getProductEntityId() {
            return ProductEntityId;
        }

        public void setProductEntityId(int ProductEntityId) {
            this.ProductEntityId = ProductEntityId;
        }

        public int getQty() {
            return Qty;
        }

        public void setQty(int Qty) {
            this.Qty = Qty;
        }

        public int getGradeId() {
            return GradeId;
        }

        public void setGradeId(int GradeId) {
            this.GradeId = GradeId;
        }

        public Object getPayTime() {
            return PayTime;
        }

        public void setPayTime(Object PayTime) {
            this.PayTime = PayTime;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public int getMaxNumber() {
            return MaxNumber;
        }

        public void setMaxNumber(int MaxNumber) {
            this.MaxNumber = MaxNumber;
        }

        public Object getDisCount() {
            return DisCount;
        }

        public void setDisCount(Object DisCount) {
            this.DisCount = DisCount;
        }

        public Object getIsCommentReply() {
            return IsCommentReply;
        }

        public void setIsCommentReply(Object IsCommentReply) {
            this.IsCommentReply = IsCommentReply;
        }

        public int getPayState() {
            return PayState;
        }

        public void setPayState(int PayState) {
            this.PayState = PayState;
        }

        public Object getStatusName() {
            return StatusName;
        }

        public void setStatusName(Object StatusName) {
            this.StatusName = StatusName;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public Object getUserCardMoney() {
            return UserCardMoney;
        }

        public void setUserCardMoney(Object UserCardMoney) {
            this.UserCardMoney = UserCardMoney;
        }

        public int getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(int TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public Object getUserCardId() {
            return UserCardId;
        }

        public void setUserCardId(Object UserCardId) {
            this.UserCardId = UserCardId;
        }

        public String getOrderDate() {
            return OrderDate;
        }

        public void setOrderDate(String OrderDate) {
            this.OrderDate = OrderDate;
        }

        public Object getProductCode() {
            return ProductCode;
        }

        public void setProductCode(Object ProductCode) {
            this.ProductCode = ProductCode;
        }

        public int getNeedBatchs() {
            return NeedBatchs;
        }

        public void setNeedBatchs(int NeedBatchs) {
            this.NeedBatchs = NeedBatchs;
        }

        public String getThumbImg() {
            return ThumbImg;
        }

        public void setThumbImg(String ThumbImg) {
            this.ThumbImg = ThumbImg;
        }

        public int getBatchStatus() {
            return BatchStatus;
        }

        public void setBatchStatus(int BatchStatus) {
            this.BatchStatus = BatchStatus;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public Object getIsComment() {
            return IsComment;
        }

        public void setIsComment(Object IsComment) {
            this.IsComment = IsComment;
        }

        public int getProductId() {
            return ProductId;
        }

        public void setProductId(int ProductId) {
            this.ProductId = ProductId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getSortId() {
            return SortId;
        }

        public void setSortId(int SortId) {
            this.SortId = SortId;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public Object getAddress() {
            return Address;
        }

        public void setAddress(Object Address) {
            this.Address = Address;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getPayStyle() {
            return PayStyle;
        }

        public void setPayStyle(int PayStyle) {
            this.PayStyle = PayStyle;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getDetailID() {
            return DetailID;
        }

        public void setDetailID(int DetailID) {
            this.DetailID = DetailID;
        }

        public List<?> getOrderBatchs() {
            return OrderBatchs;
        }

        public void setOrderBatchs(List<?> OrderBatchs) {
            this.OrderBatchs = OrderBatchs;
        }
    }
}
