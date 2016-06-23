package com.meist.pinfan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Package：com.meist.pinfan.model
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/23
 */
public class OrderDetails implements Serializable {

    /**
     * orderdetails : [{"OrderBatchs":[],"MaxNumber":0,"BatchStatus":0,"StatusName":null,"Id":136,"OrderNo":"2016060022","CreateTime":"2016-06-23 14:30:32","Address":null,"PayStyle":0,"Status":3,"PayState":0,"TotalMoney":30,"UserId":210,"PayTime":null,"IsComment":null,"IsCommentReply":null,"CXNumber":null,"DisCount":null,"OrderDate":"2016-06-30 00:00:00","UserCardMoney":null,"UserCardId":null,"Price":30,"ProductId":9,"Qty":1,"ProductEntityId":9,"GradeId":0,"ProductModel":null,"ProductName":"港式茶餐厅  ","ProductCode":null,"SortId":3,"UserName":"ios","ThumbImg":"/upload/201606/a6d87ba613fd49cda7886f76233d3ee4.jpg","SortName":null,"DetailID":136,"NeedBatchs":0}]
     * detaillist : []
     * Id : 136
     * OrderNo : 2016060022
     * UserId : 210
     * PayStyle : 0
     * CreateTime : 2016-06-23 14:30:32
     * Status : 3
     * TotalMoney : 30
     * Address : null
     * Remark : null
     * Report : null
     * ReportDateTime : 2016-06-23 15:16:19
     * ReportUserId : null
     * modifytime : null
     * PayState : 0
     * PayTime : null
     * RedPacketId : 0
     * RedPacketMoney : null
     * UserSex : null
     * UserCardId : null
     * UserCardMoney : null
     * IsComment : null
     * IsCommentReply : null
     * OrderDate : 2016-06-30 00:00:00
     * CXNumber : null
     */

    private int Id;
    private String OrderNo;
    private int UserId;
    private int PayStyle;
    private String CreateTime;
    private int Status;
    private int TotalMoney;
    private Object Address;
    private Object Remark;
    private Object Report;
    private String ReportDateTime;
    private Object ReportUserId;
    private Object modifytime;
    private int PayState;
    private Object PayTime;
    private int RedPacketId;
    private Object RedPacketMoney;
    private Object UserSex;
    private Object UserCardId;
    private Object UserCardMoney;
    private Object IsComment;
    private Object IsCommentReply;
    private String OrderDate;
    private Object CXNumber;
    /**
     * OrderBatchs : []
     * MaxNumber : 0
     * BatchStatus : 0
     * StatusName : null
     * Id : 136
     * OrderNo : 2016060022
     * CreateTime : 2016-06-23 14:30:32
     * Address : null
     * PayStyle : 0
     * Status : 3
     * PayState : 0
     * TotalMoney : 30
     * UserId : 210
     * PayTime : null
     * IsComment : null
     * IsCommentReply : null
     * CXNumber : null
     * DisCount : null
     * OrderDate : 2016-06-30 00:00:00
     * UserCardMoney : null
     * UserCardId : null
     * Price : 30
     * ProductId : 9
     * Qty : 1
     * ProductEntityId : 9
     * GradeId : 0
     * ProductModel : null
     * ProductName : 港式茶餐厅
     * ProductCode : null
     * SortId : 3
     * UserName : ios
     * ThumbImg : /upload/201606/a6d87ba613fd49cda7886f76233d3ee4.jpg
     * SortName : null
     * DetailID : 136
     * NeedBatchs : 0
     */

    private List<OrderdetailsBean> orderdetails;
    private List<?> detaillist;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getPayStyle() {
        return PayStyle;
    }

    public void setPayStyle(int PayStyle) {
        this.PayStyle = PayStyle;
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

    public int getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(int TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public Object getAddress() {
        return Address;
    }

    public void setAddress(Object Address) {
        this.Address = Address;
    }

    public Object getRemark() {
        return Remark;
    }

    public void setRemark(Object Remark) {
        this.Remark = Remark;
    }

    public Object getReport() {
        return Report;
    }

    public void setReport(Object Report) {
        this.Report = Report;
    }

    public String getReportDateTime() {
        return ReportDateTime;
    }

    public void setReportDateTime(String ReportDateTime) {
        this.ReportDateTime = ReportDateTime;
    }

    public Object getReportUserId() {
        return ReportUserId;
    }

    public void setReportUserId(Object ReportUserId) {
        this.ReportUserId = ReportUserId;
    }

    public Object getModifytime() {
        return modifytime;
    }

    public void setModifytime(Object modifytime) {
        this.modifytime = modifytime;
    }

    public int getPayState() {
        return PayState;
    }

    public void setPayState(int PayState) {
        this.PayState = PayState;
    }

    public Object getPayTime() {
        return PayTime;
    }

    public void setPayTime(Object PayTime) {
        this.PayTime = PayTime;
    }

    public int getRedPacketId() {
        return RedPacketId;
    }

    public void setRedPacketId(int RedPacketId) {
        this.RedPacketId = RedPacketId;
    }

    public Object getRedPacketMoney() {
        return RedPacketMoney;
    }

    public void setRedPacketMoney(Object RedPacketMoney) {
        this.RedPacketMoney = RedPacketMoney;
    }

    public Object getUserSex() {
        return UserSex;
    }

    public void setUserSex(Object UserSex) {
        this.UserSex = UserSex;
    }

    public Object getUserCardId() {
        return UserCardId;
    }

    public void setUserCardId(Object UserCardId) {
        this.UserCardId = UserCardId;
    }

    public Object getUserCardMoney() {
        return UserCardMoney;
    }

    public void setUserCardMoney(Object UserCardMoney) {
        this.UserCardMoney = UserCardMoney;
    }

    public Object getIsComment() {
        return IsComment;
    }

    public void setIsComment(Object IsComment) {
        this.IsComment = IsComment;
    }

    public Object getIsCommentReply() {
        return IsCommentReply;
    }

    public void setIsCommentReply(Object IsCommentReply) {
        this.IsCommentReply = IsCommentReply;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Object getCXNumber() {
        return CXNumber;
    }

    public void setCXNumber(Object CXNumber) {
        this.CXNumber = CXNumber;
    }

    public List<OrderdetailsBean> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<OrderdetailsBean> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public List<?> getDetaillist() {
        return detaillist;
    }

    public void setDetaillist(List<?> detaillist) {
        this.detaillist = detaillist;
    }

    public static class OrderdetailsBean {
        private int MaxNumber;
        private int BatchStatus;
        private Object StatusName;
        private int Id;
        private String OrderNo;
        private String CreateTime;
        private Object Address;
        private int PayStyle;
        private int Status;
        private int PayState;
        private int TotalMoney;
        private int UserId;
        private Object PayTime;
        private Object IsComment;
        private Object IsCommentReply;
        private Object CXNumber;
        private Object DisCount;
        private String OrderDate;
        private Object UserCardMoney;
        private Object UserCardId;
        private int Price;
        private int ProductId;
        private int Qty;
        private int ProductEntityId;
        private int GradeId;
        private Object ProductModel;
        private String ProductName;
        private Object ProductCode;
        private int SortId;
        private String UserName;
        private String ThumbImg;
        private Object SortName;
        private int DetailID;
        private int NeedBatchs;
        private List<?> OrderBatchs;

        public int getMaxNumber() {
            return MaxNumber;
        }

        public void setMaxNumber(int MaxNumber) {
            this.MaxNumber = MaxNumber;
        }

        public int getBatchStatus() {
            return BatchStatus;
        }

        public void setBatchStatus(int BatchStatus) {
            this.BatchStatus = BatchStatus;
        }

        public Object getStatusName() {
            return StatusName;
        }

        public void setStatusName(Object StatusName) {
            this.StatusName = StatusName;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public Object getAddress() {
            return Address;
        }

        public void setAddress(Object Address) {
            this.Address = Address;
        }

        public int getPayStyle() {
            return PayStyle;
        }

        public void setPayStyle(int PayStyle) {
            this.PayStyle = PayStyle;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getPayState() {
            return PayState;
        }

        public void setPayState(int PayState) {
            this.PayState = PayState;
        }

        public int getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(int TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public Object getPayTime() {
            return PayTime;
        }

        public void setPayTime(Object PayTime) {
            this.PayTime = PayTime;
        }

        public Object getIsComment() {
            return IsComment;
        }

        public void setIsComment(Object IsComment) {
            this.IsComment = IsComment;
        }

        public Object getIsCommentReply() {
            return IsCommentReply;
        }

        public void setIsCommentReply(Object IsCommentReply) {
            this.IsCommentReply = IsCommentReply;
        }

        public Object getCXNumber() {
            return CXNumber;
        }

        public void setCXNumber(Object CXNumber) {
            this.CXNumber = CXNumber;
        }

        public Object getDisCount() {
            return DisCount;
        }

        public void setDisCount(Object DisCount) {
            this.DisCount = DisCount;
        }

        public String getOrderDate() {
            return OrderDate;
        }

        public void setOrderDate(String OrderDate) {
            this.OrderDate = OrderDate;
        }

        public Object getUserCardMoney() {
            return UserCardMoney;
        }

        public void setUserCardMoney(Object UserCardMoney) {
            this.UserCardMoney = UserCardMoney;
        }

        public Object getUserCardId() {
            return UserCardId;
        }

        public void setUserCardId(Object UserCardId) {
            this.UserCardId = UserCardId;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
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

        public int getProductEntityId() {
            return ProductEntityId;
        }

        public void setProductEntityId(int ProductEntityId) {
            this.ProductEntityId = ProductEntityId;
        }

        public int getGradeId() {
            return GradeId;
        }

        public void setGradeId(int GradeId) {
            this.GradeId = GradeId;
        }

        public Object getProductModel() {
            return ProductModel;
        }

        public void setProductModel(Object ProductModel) {
            this.ProductModel = ProductModel;
        }

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public Object getProductCode() {
            return ProductCode;
        }

        public void setProductCode(Object ProductCode) {
            this.ProductCode = ProductCode;
        }

        public int getSortId() {
            return SortId;
        }

        public void setSortId(int SortId) {
            this.SortId = SortId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getThumbImg() {
            return ThumbImg;
        }

        public void setThumbImg(String ThumbImg) {
            this.ThumbImg = ThumbImg;
        }

        public Object getSortName() {
            return SortName;
        }

        public void setSortName(Object SortName) {
            this.SortName = SortName;
        }

        public int getDetailID() {
            return DetailID;
        }

        public void setDetailID(int DetailID) {
            this.DetailID = DetailID;
        }

        public int getNeedBatchs() {
            return NeedBatchs;
        }

        public void setNeedBatchs(int NeedBatchs) {
            this.NeedBatchs = NeedBatchs;
        }

        public List<?> getOrderBatchs() {
            return OrderBatchs;
        }

        public void setOrderBatchs(List<?> OrderBatchs) {
            this.OrderBatchs = OrderBatchs;
        }
    }
}
